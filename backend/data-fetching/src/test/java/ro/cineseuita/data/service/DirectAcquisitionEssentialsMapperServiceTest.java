package ro.cineseuita.data.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionItemEssentialsMapperService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchDirectAcquisitionContractDetails;
import ro.cineseuita.data.supplier.entity.Supplier;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectAcquisitionEssentialsMapperServiceTest {

    private DirectAcquisitionEssentialsMapperService service;
    private DirectAcquisitionContractDetails contractDetails;
    private ContractingAuthorityDataRepository contractingAuthorityDataRepository;
    private SupplierDataRepository supplierDataRepository;

    @Before
    public void setUp() {
        contractingAuthorityDataRepository = mock(ContractingAuthorityDataRepository.class);
        supplierDataRepository = mock(SupplierDataRepository.class);
        service = new DirectAcquisitionEssentialsMapperService(new DirectAcquisitionItemEssentialsMapperService(), contractingAuthorityDataRepository, supplierDataRepository);
        ObjectMapperService objectMapperService = new ObjectMapperService();
        contractDetails = objectMapperService.mapToDirectAcquisitionContractDetails(new FetchDirectAcquisitionContractDetails(-1L).getMockResponse());
    }

    @Test
    public void mapToDirectAcquisitionContractEssentials() {
        when(contractingAuthorityDataRepository.findById(contractDetails.getContractingAuthorityID())).thenReturn(of(new ContractingAuthority()));
        when(supplierDataRepository.findById(contractDetails.getSupplierId())).thenReturn(of(new Supplier()));

        DirectAcquisitionContractEssentials contractEssentials = service.mapToDirectAcquisitionContractEssentials(contractDetails);

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
