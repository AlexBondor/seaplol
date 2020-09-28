package ro.cineseuita.data.essentials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionItemEssentials;

@Service
public class DirectAcquisitionItemEssentialsMapperService {

    @Autowired
    public DirectAcquisitionItemEssentialsMapperService() {
    }

    public DirectAcquisitionItemEssentials mapToDirectAcquisitionItemEssentials(DirectAcquisitionItem itemDetails) {
        DirectAcquisitionItemEssentials itemEssentials = new DirectAcquisitionItemEssentials();
        itemEssentials.set_id(itemDetails.getDirectAcquisitionItemID());
        itemEssentials.setName(itemDetails.getCatalogItemName());
        itemEssentials.setCatalogPrice(itemDetails.getCatalogItemPrice());
        itemEssentials.setDescription(itemDetails.getCatalogItemDescription());
        itemEssentials.setEstimatedPrice(itemDetails.getItemEstimatedPrice());
        itemEssentials.setClosingPrice(itemDetails.getItemClosingPrice());
        itemEssentials.setQuantity(itemDetails.getItemQuantity());
        itemEssentials.setRequestedQuantity(itemDetails.getItemRequestedQuantity());
        itemEssentials.setMeasureUnit(itemDetails.getItemMeasureUnit());
        itemEssentials.setAssignedUserEmail(itemDetails.getAssignedUserEmail());

        return itemEssentials;
    }
}
