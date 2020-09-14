package ro.cineseuita.cpv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.contract.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.cpv.entity.components.CpvDataNode;
import ro.cineseuita.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.essentials.service.DirectAcquisitionEssentialsMapperService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.notNull;

public class CpvNationalDataServiceTest {

    private static final double NEGLIGENT_ERROR = 0.01;
    @Mock
    private DirectAcquisitionContractService directAcquisitionContractService;

    @Mock
    private DirectAcquisitionContractRepository directAcquisitionContractRepository;

    @Mock
    private DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService;

    private CpvNationalDataService cpvNationalDataService;


    private final ObjectMapper mapper = new ObjectMapper();
    private CpvSimpleTreeNode cpvSimpleTree;
    private List<DirectAcquisitionContractDetails> contractList;

    @Before
    public void setUp() throws Exception {
        setupCpvSimpleTree();
        setupContractList();

        directAcquisitionContractService = mock(DirectAcquisitionContractService.class);
        when(directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsStreamed()).thenReturn(contractList.stream());

        directAcquisitionContractRepository = mock(DirectAcquisitionContractRepository.class);
        when(directAcquisitionContractRepository.count()).thenReturn(Long.valueOf(contractList.size()));

        directAcquisitionEssentialsMapperService = new DirectAcquisitionEssentialsMapperService(null, null, null);

        cpvNationalDataService = new CpvNationalDataService(directAcquisitionContractService, directAcquisitionContractRepository, directAcquisitionEssentialsMapperService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComputeNationalWideCpvData() {
        CpvDataNode result = cpvNationalDataService.computeNationalWideCpvData(cpvSimpleTree);
        notNull(result, "The result cannot be null!");

        Double totalValue = contractList.stream().map(DirectAcquisitionContractDetails::getDirectAcquisitionItems).flatMap(List::stream).mapToDouble(DirectAcquisitionItem::getTotalItemCost).sum();
        assertTrue(Math.abs(totalValue - result.getTotal()) < NEGLIGENT_ERROR);

        Double totalItems = contractList.stream().map(DirectAcquisitionContractDetails::getDirectAcquisitionItems).flatMap(List::stream).mapToDouble(DirectAcquisitionItem::getItemQuantity).sum();
        assertEquals(totalItems.longValue(), result.getNumberOfItems().longValue());
    }

    private void setupCpvSimpleTree() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/cpvSimpleTree.txt")));
        cpvSimpleTree = mapper.readValue(bufferedReader.readLine(), CpvSimpleTreeNode.class);
    }

    private void setupContractList() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/contracts5000.txt")));
        contractList = mapper.readValue(bufferedReader.readLine(),
                mapper.getTypeFactory().constructCollectionType(List.class, DirectAcquisitionContractDetails.class));
    }
}