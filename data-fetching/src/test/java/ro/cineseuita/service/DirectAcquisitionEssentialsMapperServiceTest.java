package ro.cineseuita.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.essentials.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.essentials.entity.directacquisitions.DirectAcquisitionContractEssentials;
import ro.cineseuita.essentials.service.ContractingAuthorityEssentialsMapperService;
import ro.cineseuita.essentials.service.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.essentials.service.DirectAcquisitionItemEssentialsMapperService;
import ro.cineseuita.essentials.service.SupplierEssentialsMapperService;
import ro.cineseuita.shared.ObjectMapperService;
import ro.cineseuita.shared.requests.FetchContractingAuthorityDetails;
import ro.cineseuita.shared.requests.FetchDirectAcquisitionContractDetails;
import ro.cineseuita.shared.requests.FetchSupplierDetails;
import ro.cineseuita.supplier.entity.SupplierDetails;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DirectAcquisitionEssentialsMapperServiceTest {

    private DirectAcquisitionEssentialsMapperService service;
    private DirectAcquisitionContractDetails contractDetails;
    private SupplierDetails supplierDetails;
    private ContractingAuthorityDetails contractingAuthorityDetails;

    @Before
    public void setUp() throws IOException {
        service = new DirectAcquisitionEssentialsMapperService(new SupplierEssentialsMapperService(), new DirectAcquisitionItemEssentialsMapperService(), new ContractingAuthorityEssentialsMapperService());
        ObjectMapperService objectMapperService = new ObjectMapperService();
        contractDetails = objectMapperService.mapToDirectAcquisitionContractDetails(new FetchDirectAcquisitionContractDetails(-1L).getMockResponse());
        supplierDetails = objectMapperService.mapToSupplier(new FetchSupplierDetails(-1L).getMockResponse());
        contractingAuthorityDetails = objectMapperService.mapToContractingAuthorityDetails(new FetchContractingAuthorityDetails(-1L).getMockResponse());
    }

    @Test
    public void mapToDirectAcquisitionContractEssentials() {
        DirectAcquisitionContractEssentials contractEssentials = service.mapToDirectAcquisitionContractEssentials(contractDetails, supplierDetails, contractingAuthorityDetails);

        assertEquals(contractDetails.getDirectAcquisitionID(), contractEssentials.get_id());
        assertEquals(contractDetails.getDirectAcquisitionName(), contractEssentials.getName());
        assertEquals(contractDetails.getDirectAcquisitionDescription(), contractEssentials.getDescription());
        assertEquals(contractDetails.getEstimatedValue(), contractEssentials.getEstimatedValue());
        assertEquals(contractDetails.getClosingValue(), contractEssentials.getClosingValue());
        assertEquals(new DateTime(contractDetails.getPublicationDate()).withTimeAtStartOfDay(), contractEssentials.getPublicationDate().withTimeAtStartOfDay());
        assertEquals(new DateTime(contractDetails.getFinalizationDate()).withTimeAtStartOfDay(), contractEssentials.getFinalizationDate().withTimeAtStartOfDay());
        assertEquals(contractDetails.getDeliveryCondition(), contractEssentials.getDeliveryCondition());
        assertEquals(contractDetails.getPaymentCondition(), contractEssentials.getPaymentCondition());
        assertEquals(contractDetails.getCpvCode().getId(), contractEssentials.getCpvCode().get_id());
        assertEquals(contractDetails.getCpvCode().getText(), contractEssentials.getCpvCode().getCode());
        assertEquals(contractDetails.getCorruption(), contractEssentials.getCorruption(), 0.5);
    }

    @Test
    public void mapToDirectAcquisitionContractMinimalForSupplierEssentials() {
        DirectAcquisitionContractMinimal minimalContract = service.mapToDirectAcquisitionContractMinimal(contractDetails);
        assertEquals(contractDetails.getDirectAcquisitionID(), minimalContract.get_id());
        assertEquals(contractDetails.getDirectAcquisitionName(), minimalContract.getName());
        assertEquals(contractDetails.getClosingValue(), minimalContract.getClosingValue());
        assertEquals(contractDetails.getCpvCode().getId(), minimalContract.getCpvCode().get_id());
        assertEquals(contractDetails.getCpvCode().getText(), minimalContract.getCpvCode().getCode());
        assertEquals(contractDetails.getSysAcquisitionContractTypeID().intValue(), minimalContract.getType().getNumVal());
        assertEquals(new DateTime(contractDetails.getFinalizationDate()).withTimeAtStartOfDay(), minimalContract.getFinalizationDate().withTimeAtStartOfDay());

    }
}
