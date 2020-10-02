package ro.cineseuita.data.service;

import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.data.essentials.mappers.SupplierEssentialsMapperService;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchSupplierDetails;
import ro.cineseuita.data.supplier.entity.SupplierDetails;

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
        SupplierEssentials supplierForDirectAcquisitionEssentials = service.mapToSupplierEssentials(supplierDetails);

        assertEquals(supplierForDirectAcquisitionEssentials.get_id(), supplierDetails.getId());
        assertEquals(supplierForDirectAcquisitionEssentials.getName(), supplierDetails.getName());
        assertEquals(supplierForDirectAcquisitionEssentials.getCui(), supplierDetails.getCui());
        assertEquals(supplierForDirectAcquisitionEssentials.getLegalRepresentative(), supplierDetails.getRegistration().getLegalRepresentative());
        assertEquals(supplierForDirectAcquisitionEssentials.getAddress(), supplierDetails.getAddress());
    }
}
