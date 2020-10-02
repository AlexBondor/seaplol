package ro.cineseuita.data.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractService;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurement;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurementClassifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemMeasurementService {

    private final DirectAcquisitionContractService directAcquisitionContractService;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;

    @Autowired
    public ItemMeasurementService(DirectAcquisitionContractService directAcquisitionContractService, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository) {
        this.directAcquisitionContractService = directAcquisitionContractService;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
    }

    void addItemMeasurementClassToAllContractItems() {
        List<DirectAcquisitionContractDetails> detailsList = new ArrayList<>();
        final long[] i = {0, 0};
        AtomicInteger c = new AtomicInteger();
        directAcquisitionContractService.getAllDirectAcquisitionContractsDetailsStreamed()
                .forEach(directAcquisitionContractDetails ->
                        {
                            if (c.get() % 100000 == 0) { //
                                System.out.printf("Reached %d, saving and then clearing so we can clear-up some heap space", c.get());
                                directAcquisitionContractDetailsRepository.saveAll(detailsList);
                                detailsList.clear();
                            }
                            System.out.println("Processing contract " + c.getAndIncrement());
                            detailsList.add(directAcquisitionContractDetails);
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
                        }
                );


        double perc = i[1] * 100 / i[0];
        System.out.println("There were a total of " + i[0] + " items. Out of these, " + i[1] + "(" + perc + "%) were in a defined bucked and " + (i[0] - i[1]) + " were put in the general class.");
        directAcquisitionContractDetailsRepository.saveAll(detailsList);

    }


}
