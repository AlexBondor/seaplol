package ro.cineseuita.service;

import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.essentials.entity.directacquisitions.SupplierForDirectAcquisitionEssentials;
import ro.cineseuita.essentials.service.SupplierEssentialsMapperService;
import ro.cineseuita.shared.ObjectMapperService;
import ro.cineseuita.shared.requests.FetchSupplierDetails;
import ro.cineseuita.supplier.entity.SupplierDetails;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SupplierDetailsForDirectAcquisitionEssentialsMapperServiceTest {

    private SupplierEssentialsMapperService service;
    private ObjectMapperService objectMapperService;

    @Before
    public void setUp() {
        service = new SupplierEssentialsMapperService();
        objectMapperService = new ObjectMapperService();
    }

    @Test
    public void mapToSupplierEssentials() throws IOException {
        SupplierDetails supplierDetails = objectMapperService.mapToSupplier(new FetchSupplierDetails(-1L).getMockResponse());
        SupplierForDirectAcquisitionEssentials supplierForDirectAcquisitionEssentials = service.mapToSupplierWithContractsForDirectAcquisitionEssentials(supplierDetails);

        assertEquals(supplierForDirectAcquisitionEssentials.get_id(), supplierDetails.getId());
        assertEquals(supplierForDirectAcquisitionEssentials.getName(), supplierDetails.getName());
        assertEquals(supplierForDirectAcquisitionEssentials.getNumericFiscalNumber(), supplierDetails.getCui());
        assertEquals(supplierForDirectAcquisitionEssentials.getAddress(), supplierDetails.getAddress().getAddress());
        assertEquals(supplierForDirectAcquisitionEssentials.getPhone(), supplierDetails.getAddress().getPhone());
        assertEquals(supplierForDirectAcquisitionEssentials.getFax(), supplierDetails.getAddress().getFax());
        assertEquals(supplierForDirectAcquisitionEssentials.getUrl(), supplierDetails.getAddress().getWebsite());
        assertEquals(supplierForDirectAcquisitionEssentials.getCity(), supplierDetails.getAddress().getCity());
        assertEquals(supplierForDirectAcquisitionEssentials.getCounty(), supplierDetails.getAddress().getCounty());
        assertEquals(supplierForDirectAcquisitionEssentials.getPostalCode(), supplierDetails.getAddress().getPostalCode());
    }
}
