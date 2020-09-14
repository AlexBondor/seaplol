package ro.cineseuita.service;

import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.essentials.entity.directacquisitions.DirectAcquisitionItemEssentials;
import ro.cineseuita.essentials.service.DirectAcquisitionItemEssentialsMapperService;
import ro.cineseuita.shared.ObjectMapperService;
import ro.cineseuita.shared.requests.FetchDirectAcquisitionContractDetails;

import static org.junit.Assert.assertEquals;

public class DirectAcquisitionItemEssentialsMapperServiceTest {

    private DirectAcquisitionItemEssentialsMapperService service;
    private ObjectMapperService objectMapperService;

    @Before
    public void setUp() {
        service = new DirectAcquisitionItemEssentialsMapperService();
        objectMapperService = new ObjectMapperService();
    }

    @Test
    public void mapToDirectAcquisitionItemEssentials() {
        DirectAcquisitionContractDetails contractDetails = objectMapperService.mapToDirectAcquisitionContractDetails(new FetchDirectAcquisitionContractDetails(-1L).getMockResponse());
        DirectAcquisitionItem itemDetails = contractDetails.getDirectAcquisitionItems().get(0);

        DirectAcquisitionItemEssentials itemEssentials = service.mapToDirectAcquisitionItemEssentials(itemDetails);

        assertEquals(itemEssentials.get_id(), itemDetails.getDirectAcquisitionItemID());
        assertEquals(itemEssentials.getName(), itemDetails.getCatalogItemName());
        assertEquals(itemEssentials.getDescription(), itemDetails.getCatalogItemDescription());
        assertEquals(itemEssentials.getCatalogPrice(), itemDetails.getCatalogItemPrice());
        assertEquals(itemEssentials.getEstimatedPrice(), itemDetails.getItemEstimatedPrice());
        assertEquals(itemEssentials.getClosingPrice(), itemDetails.getItemClosingPrice());
        assertEquals(itemEssentials.getQuantity(), itemDetails.getItemQuantity());
        assertEquals(itemEssentials.getRequestedQuantity(), itemDetails.getItemRequestedQuantity());
        assertEquals(itemEssentials.getMeasureUnit(), itemDetails.getItemMeasureUnit());
        assertEquals(itemEssentials.getAssignedUserEmail(), itemDetails.getAssignedUserEmail());
    }
}
