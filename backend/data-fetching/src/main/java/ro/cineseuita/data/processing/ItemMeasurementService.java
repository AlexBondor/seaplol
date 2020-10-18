package ro.cineseuita.data.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurement;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurementClassifier;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemMeasurementService {

    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;

    @Autowired
    public ItemMeasurementService(DirectAcquisitionContractFetchService directAcquisitionContractFetchService, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository) {
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
    }

    void addItemMeasurementClassToAllContractItems() {
        final long[] i = {0, 0};
        AtomicInteger c = new AtomicInteger();
        directAcquisitionContractFetchService.getAllDirectAcquisitionContractsDetailsStreamed()
                .parallel()
                .forEach(directAcquisitionContractDetails ->
                        {
                            System.out.println("Processing contract " + c.getAndIncrement());
                            directAcquisitionContractDetails.getDirectAcquisitionItems()
                                    .forEach(directAcquisitionItem ->
                                            {
                                                i[0]++;
                                                String itemMeasureUnit = directAcquisitionItem.getItemMeasureUnit();
                                                ItemMeasurement clasz = ItemMeasurementClassifier.getBucket(itemMeasureUnit);
                                                directAcquisitionItem.setItemMeasureClass(clasz);

                                                if (!clasz.equals(ItemMeasurement.UM)) {
                                                    i[1]++;
                                                }
                                                System.out.println("Done item " + i[0]);
                                            }
                                    );
                            directAcquisitionContractDetailsRepository.save(directAcquisitionContractDetails);
                        }
                );


        double perc = i[1] * 100.0 / i[0];
        System.out.println("There were a total of " + i[0] + " items. Out of these, " + i[1] + "(" + perc + "%) were in a defined bucked and " + (i[0] - i[1]) + " were put in the general class.");
    }


}
