package ro.cineseuita.data.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionItemEssentialsMapperService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchDirectAcquisitionContractDetails;

import static org.junit.Assert.assertEquals;

public class DirectAcquisitionEssentialsMapperServiceTest {

    private DirectAcquisitionEssentialsMapperService service;
    private DirectAcquisitionContractDetails contractDetails;

    @Before
    public void setUp() {
        service = new DirectAcquisitionEssentialsMapperService(new DirectAcquisitionItemEssentialsMapperService());
        ObjectMapperService objectMapperService = new ObjectMapperService();
        contractDetails = objectMapperService.mapToDirectAcquisitionContractDetails(new FetchDirectAcquisitionContractDetails(-1L).getMockResponse());
    }

    @Test
    public void mapToDirectAcquisitionContractEssentials() {
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
