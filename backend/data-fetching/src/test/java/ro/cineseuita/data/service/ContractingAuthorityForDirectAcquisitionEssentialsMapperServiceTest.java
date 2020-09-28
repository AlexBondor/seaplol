package ro.cineseuita.data.service;

import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.essentials.directcontract.entity.ContractingAuthorityForDirectAcquisitionEssentials;
import ro.cineseuita.data.essentials.service.ContractingAuthorityEssentialsMapperService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchContractingAuthorityDetails;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ContractingAuthorityForDirectAcquisitionEssentialsMapperServiceTest {

    private ObjectMapperService objectMapperService;
    private ContractingAuthorityEssentialsMapperService service;

    @Before
    public void setUp() {
        objectMapperService = new ObjectMapperService();
        service = new ContractingAuthorityEssentialsMapperService();
    }

    @Test
    public void mapToContractingAuthorityEssentials() throws IOException {
        ContractingAuthorityDetails contractingAuthorityDetails = objectMapperService.mapToContractingAuthorityDetails(new FetchContractingAuthorityDetails(-1L).getMockResponse());

        ContractingAuthorityForDirectAcquisitionEssentials contractingAuthorityForDirectAcquisitionEssentials = service.mapToContractingAuthorityEssentials(contractingAuthorityDetails);

        assertEquals(contractingAuthorityForDirectAcquisitionEssentials.get_id(), Long.valueOf(contractingAuthorityDetails.getId()));
        assertEquals(contractingAuthorityForDirectAcquisitionEssentials.getName(), contractingAuthorityDetails.getName());
        assertEquals(contractingAuthorityForDirectAcquisitionEssentials.getCui(), contractingAuthorityDetails.getCui());
        assertEquals(contractingAuthorityForDirectAcquisitionEssentials.getLegalRepresentative(), contractingAuthorityDetails.getRegistration().getLegalRepresentative());
        assertEquals(contractingAuthorityForDirectAcquisitionEssentials.getAddress(), contractingAuthorityDetails.getAddress());
    }
}
