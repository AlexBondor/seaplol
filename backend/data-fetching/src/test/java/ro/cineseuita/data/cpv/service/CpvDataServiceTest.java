package ro.cineseuita.data.cpv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.data.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.cpv.entity.components.CpvDataNode;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.data.cpv.repository.ContractingAuthorityCpvDataRepository;
import ro.cineseuita.data.cpv.repository.NationalCpvDataRepository;
import ro.cineseuita.data.cpv.repository.NationalCpvDataSimplifiedRepository;
import ro.cineseuita.data.cpv.repository.SupplierCpvDataRepository;
import ro.cineseuita.data.shared.itemMeasurement.CostCountAverage;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;

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

public class CpvDataServiceTest {

    private static final double NEGLIGENT_ERROR = 0.01;
    private final ObjectMapper mapper = new ObjectMapper();
    @Mock
    private DirectAcquisitionContractService directAcquisitionContractService;
    @Mock
    private DirectAcquisitionContractRepository directAcquisitionContractRepository;
    @Mock
    private NationalCpvDataRepository nationalCpvDataRepository;
    private NationalCpvDataSimplifiedRepository nationalCpvDataSimplifiedRepository;
    @Mock
    private ContractingAuthorityDataRepository contractingAuthorityRepository;
    @Mock
    private ContractingAuthorityCpvDataRepository contractingAuthorityCpvDataRepository;
    @Mock
    private SupplierDataRepository supplierDataRepository;
    @Mock
    private SupplierCpvDataRepository supplierCpvDataRepository;
    private CpvDataService cpvDataService;
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

        contractingAuthorityRepository = mock(ContractingAuthorityDataRepository.class);
        contractingAuthorityCpvDataRepository = mock(ContractingAuthorityCpvDataRepository.class);

        supplierDataRepository = mock(SupplierDataRepository.class);
        supplierCpvDataRepository = mock(SupplierCpvDataRepository.class);

        nationalCpvDataRepository = mock(NationalCpvDataRepository.class);
        nationalCpvDataSimplifiedRepository = mock(NationalCpvDataSimplifiedRepository.class);


        cpvDataService = new CpvDataService(directAcquisitionContractService, directAcquisitionContractRepository, nationalCpvDataRepository, contractingAuthorityRepository, contractingAuthorityCpvDataRepository, supplierDataRepository, supplierCpvDataRepository, nationalCpvDataSimplifiedRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComputeNationalWideCpvData() {
        CpvDataNode result = cpvDataService.computeNationalWideCpvData(cpvSimpleTree);
        notNull(result, "The result cannot be null!");

        Double totalValue = contractList.stream().map(DirectAcquisitionContractDetails::getDirectAcquisitionItems).flatMap(List::stream).mapToDouble(DirectAcquisitionItem::getTotalItemCost).sum();
        assertTrue(Math.abs(totalValue - result.getTotal()) < NEGLIGENT_ERROR);
        double valueOfAllItemsSummed = result.getItemMeasurementStats().getItemMeasurementCostCount().values().stream().mapToDouble(CostCountAverage::getCost).sum();
        assertTrue(Math.abs(totalValue - valueOfAllItemsSummed) < NEGLIGENT_ERROR);


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