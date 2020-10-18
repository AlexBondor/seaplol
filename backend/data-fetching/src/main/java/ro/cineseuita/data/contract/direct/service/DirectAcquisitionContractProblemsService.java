package ro.cineseuita.data.contract.direct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionItem;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.data.cpv.repository.NationalCpvDataRepository;
import ro.cineseuita.data.shared.itemMeasurement.CostCountAverage;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurement;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurementClassifier;

import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionProblem.PRICE_ABOVE_AVERAGE;
import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionProblem.VALUE_5k_MARGIN;

@Service
public class DirectAcquisitionContractProblemsService {

    private static final double closenessFactorPercentage = 2;
    private static final double max = 5000;
    private static final double min = max - closenessFactorPercentage / 100 * max;
    private static final double DEVIATION_PERCENTAGE_PROBLEM_THRESHOLD = 250;

    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final NationalCpvDataRepository nationalCpvDataRepository;

    @Autowired
    public DirectAcquisitionContractProblemsService(DirectAcquisitionContractFetchService directAcquisitionContractFetchService, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, NationalCpvDataRepository nationalCpvDataRepository) {
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.nationalCpvDataRepository = nationalCpvDataRepository;
    }

    public void computeProblems() {
        directAcquisitionContractFetchService.getAllAcceptedDirectAcquisitionContractDetailsStreamed().forEach(contract -> {
            compute5kMarginLimitProblem(contract);
            computePriceAboveAverageProblem(contract);
            directAcquisitionContractDetailsRepository.save(contract);
        });
    }

    private void compute5kMarginLimitProblem(DirectAcquisitionContractDetails contract) {
        if (isWithin5kBounds(contract.getSecondCurrencyEstimatedValue())) {
            contract.getProblems().addProblem(VALUE_5k_MARGIN);
        }
    }

    private void computePriceAboveAverageProblem(DirectAcquisitionContractDetails contract) {
        if (contract.getDirectAcquisitionItems().stream().anyMatch(this::isWayAboveAveragePrice)) {
            contract.getProblems().addProblem(PRICE_ABOVE_AVERAGE);
        }
    }

    private boolean isWayAboveAveragePrice(DirectAcquisitionItem item) {
        String cpvCode = item.getCpvCode().getLocaleKey();
        String measurementUnit = item.getItemMeasureUnit();
        ItemMeasurement measurementBucket = ItemMeasurementClassifier.getBucket(measurementUnit);
        NationalCpvData nationalCpvData = nationalCpvDataRepository.findById(cpvCode).get();
        CostCountAverage costCountAverageForBucket = nationalCpvData.getItemMeasurementStats().getByItemMeasurement(measurementBucket);
        Double itemAverageCost = item.getAverageItemPrice();
        Double nationalAverageCost = costCountAverageForBucket.getAverage();

        double deviationPercentage = itemAverageCost * 100 / nationalAverageCost;

        return deviationPercentage > DEVIATION_PERCENTAGE_PROBLEM_THRESHOLD;
    }


    private boolean isWithin5kBounds(Double closingValueInEur) {
        return closingValueInEur >= min && closingValueInEur <= max;
    }
}
