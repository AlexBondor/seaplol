package ro.cineseuita.data.service;

import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionItem;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionItemEssentials;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionItemEssentialsMapperService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchDirectAcquisitionContractDetails;

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
    }
}
