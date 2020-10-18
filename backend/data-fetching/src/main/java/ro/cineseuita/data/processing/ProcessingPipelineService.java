package ro.cineseuita.data.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.contract.shared.service.ContractsTotalSpendingByTypeService;
import ro.cineseuita.data.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.data.cpv.service.CpvCodesService;
import ro.cineseuita.data.cpv.service.CpvDataService;
import ro.cineseuita.data.cpv.service.CpvTreeConstructorService;
import ro.cineseuita.data.shared.MissingEntitiesResolutionService;
import ro.cineseuita.data.shared.Period;
import ro.cineseuita.data.supplier.service.SupplierService;

import java.io.IOException;

@Service
public class ProcessingPipelineService {

    private static final Boolean FETCH_CONTRACTING_AUTHORITIES = false;
    private static final Boolean FETCH_SUPPLIERS = false;
    private static final Boolean FETCH_DIRECT_ACQUISITION_CONTRACTS = false;
    private static final Boolean FETCH_CPV_CODES_FROM_XLS = false;
    private static final Boolean FETCH_SUPPLIERS_OPEN_API_DETAILS = false;
    private static final Boolean FETCH_SUPPLIERS_OPEN_API_BALANCES = false;

    private static final Boolean RESOLVE_MISSING_CONTRACTING_AUTHORITIES_AND_SUPPLIERS = false;
    private static final Boolean RESOLVE_MISSING_CONTRACTS = false;
    private static final Boolean NORMALIZE_SUPPLIER_CUI = false;


    private static final Boolean COMPUTE_ITEM_MEASUREMENT_CLASS = false;
    private static final Boolean COMPUTE_TOTAL_CONTRACTS_SPENDING_BY_TYPE = false;
    private static final Boolean COMPUTE_CONTRACTING_AUTHORITIES_TOTAL_SPENDING_BY_TYPE = false;
    private static final Boolean COMPUTE_SUPPLIERS_TOTAL_SPENDING_BY_TYPE = false;
    private static final Boolean COMPUTE_NATIONAL_CPV_DATA = false;
    private static final Boolean COMPUTE_CONTRACTING_AUTHORITY_CPV_DATA = false;
    private static final Boolean COMPUTE_SUPPLIER_CPV_DATA = false;
    private static final Boolean COMPUTE_CPV_TREE = COMPUTE_NATIONAL_CPV_DATA || COMPUTE_CONTRACTING_AUTHORITY_CPV_DATA || COMPUTE_SUPPLIER_CPV_DATA || false;
    private static final Boolean COMPUTE_SUPPLIER_AVERAGE_REVENUE_FROM_PUBLIC_INSTITUTION_PER_YEAR_AND_EMPLOYEE_COUNT = false;

    private static final Boolean MAP_CONTRACTING_AUTHORITIES_TO_ESSENTIALS = false;
    private static final Boolean MAP_SUPPLIERS_TO_ESSENTIALS = false;
    private static final Boolean MAP_DIRECT_ACQUISITION_CONTRACTS_TO_ESSENTIALS = false;

    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;

    private final SupplierService supplierService;
    private final ContractingAuthorityService contractingAuthorityService;
    private final ContractsTotalSpendingByTypeService contractsTotalSpendingByTypeService;
    private final CpvCodesService cpvCodesService;
    private final MissingEntitiesResolutionService missingEntitiesResolutionService;
    private final ItemMeasurementService itemMeasurementService;
    private final CpvTreeConstructorService cpvTreeConstructorService;
    private final CpvDataService cpvDataService;

    @Autowired
    public ProcessingPipelineService(DirectAcquisitionContractFetchService directAcquisitionContractFetchService, SupplierService supplierService,
                                     ContractingAuthorityService contractingAuthorityService, ContractsTotalSpendingByTypeService contractsTotalSpendingByTypeService,
                                     CpvCodesService cpvCodesService, MissingEntitiesResolutionService missingEntitiesResolutionService,
                                     ItemMeasurementService itemMeasurementService, CpvTreeConstructorService cpvTreeConstructorService, CpvDataService cpvDataService) {
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;

        this.supplierService = supplierService;
        this.contractingAuthorityService = contractingAuthorityService;
        this.contractsTotalSpendingByTypeService = contractsTotalSpendingByTypeService;
        this.cpvCodesService = cpvCodesService;
        this.missingEntitiesResolutionService = missingEntitiesResolutionService;
        this.itemMeasurementService = itemMeasurementService;
        this.cpvTreeConstructorService = cpvTreeConstructorService;
        this.cpvDataService = cpvDataService;
    }

    public void execute() throws IOException, InterruptedException {
        System.out.println("BEGINNING EXECUTION PIPELINE");
        fetchContractingAuthorities();
        fetchSuppliers();
        fetchSuppliersOpenApiDetails();
        fetchSuppliersOpenApiBalances();
        fetchContracts();
        fetchCpvCodesFromXls();

        resolveMissingContractingAuthoritiesAndSuppliers();
        resolveMissingContracts();
        normalizeCuiForEachSupplier();

        computeItemMeasurementClass();
        computeContractsTotalSpendingByType();
        computeContractingAuthoritiesTotalSpendingByType();
        computeSuppliersTotalSpendingByType();
        CpvSimpleTreeNode root = computeCpvTree();
        computeNationalCpvData(root);
        computeContractingAuthorityCpvData(root);
        computeSupplierCpvData(root);

        computeExtraInformationFromOpenApiData();

        mapContractingAuthoritiesToEssentials();
        mapSuppliersToEssentials();
        mapDirectAcquisitionContractsToEssentials();

        System.out.println("EXECUTION PIPELINE COMPLETE");
    }

    private void fetchContractingAuthorities() throws IOException {
        if (FETCH_CONTRACTING_AUTHORITIES) {
            System.out.println("--- FETCHING CONTRACTING AUTHORITIES (LITE) ---");
            contractingAuthorityService.fetchAllContractingAuthoritiesLite();
            System.out.println("--- DONE FETCHING CONTRACTING AUTHORITIES (LITE) ---");

            System.out.println("--- FETCHING CONTRACTING AUTHORITIES (DETAILS) ---");
            contractingAuthorityService.fetchAllContractingAuthorityDetails();
            System.out.println("--- DONE FETCHING CONTRACTING AUTHORITIES (LITE) ---");
        }
    }

    private void fetchSuppliers() throws IOException {
        if (FETCH_SUPPLIERS) {
            System.out.println("--- FETCHING SUPPLIERS (LITE) ---");
            supplierService.fetchAllSuppliersLite();
            System.out.println("--- DONE FETCHING SUPPLIERS (LITE) ---");

            System.out.println("--- FETCHING SUPPLIERS (DETAILS) ---");
            supplierService.fetchAllSupplierDetails();
            System.out.println("--- DONE FETCHING SUPPLIERS (DETAILS) ---");
        }
    }

    private void fetchContracts() throws IOException, InterruptedException {
        if (FETCH_DIRECT_ACQUISITION_CONTRACTS) {
            for (Period period : Period.getYears()) {
                int year = period.getNumVal();
                System.out.println("--- FETCHING CONTRACTS FOR " + year + "  ---");
                directAcquisitionContractFetchService.fullFetch(year);
                System.out.println("--- DONE FETCHING CONTRACTS FOR " + year + "  ---");
            }
        }
    }

    private void fetchCpvCodesFromXls() throws IOException {
        if (FETCH_CPV_CODES_FROM_XLS) {
            System.out.println("--- FETCHING CPV CODES FROM XLS ---");
            cpvCodesService.parseCpvCodesXls();
            cpvCodesService.assignParentCodes();
            System.out.println("--- DONE FETCHING CPV CODES FROM XLS  ---");
        }
    }

    private void fetchSuppliersOpenApiDetails() {
        if (FETCH_SUPPLIERS_OPEN_API_DETAILS) {
            System.out.println("--- FETCHING SUPPLIERS OPEN API DETAILS ---");
            supplierService.fetchAllSupplierOpenApiDetails();
            System.out.println("--- DONE FETCHING SUPPLIERS OPEN API DETAILS ---");
        }
    }

    private void fetchSuppliersOpenApiBalances() {
        if (FETCH_SUPPLIERS_OPEN_API_BALANCES) {
            System.out.println("--- FETCHING SUPPLIERS OPEN API BALANCES ---");
            supplierService.fetchAllSupplierOpenApiBalances();
            System.out.println("--- DONE FETCHING SUPPLIERS OPEN API BALANCES ---");
        }
    }

    private void resolveMissingContractingAuthoritiesAndSuppliers() {
        if (RESOLVE_MISSING_CONTRACTING_AUTHORITIES_AND_SUPPLIERS) {
            System.out.println("--- RESOLVING MISSING CONTRACTING AUTHORITIES AND SUPPLIERS ---");
            missingEntitiesResolutionService.resolveMissingContractingAuthoritiesAndSuppliers();
            System.out.println("--- DONE RESOLVING MISSING CONTRACTING AUTHORITIES AND SUPPLIERS ---");
        }
    }

    private void resolveMissingContracts() {
        if (RESOLVE_MISSING_CONTRACTS) {
            System.out.println("--- RESOLVING MISSING CONTRACTS ---");
            missingEntitiesResolutionService.resolveMissingContractDetails();
            System.out.println("--- DONE RESOLVING MISSING CONTRACTS ---");
        }
    }

    private void normalizeCuiForEachSupplier() {
        if (NORMALIZE_SUPPLIER_CUI) {
            System.out.println("--- NORMALIZING SUPPLIER CUIS ---");
            supplierService.normalizeCuiForEachSupplier();
            System.out.println("--- DONE NORMALIZING SUPPLIER CUIS ---");
        }
    }

    private void mapContractingAuthoritiesToEssentials() {
        if (MAP_CONTRACTING_AUTHORITIES_TO_ESSENTIALS) {
            System.out.println("--- MAPPING CONTRACTING AUTHORITIES TO ESSENTIALS ---");
            contractingAuthorityService.mapContractingAuthoritiesToEssentials();
            System.out.println("--- DONE MAPPING CONTRACTING AUTHORITIES TO ESSENTIALS ---");
        }
    }

    private void mapSuppliersToEssentials() {
        if (MAP_SUPPLIERS_TO_ESSENTIALS) {
            System.out.println("--- MAPPING SUPPLIERS TO ESSENTIALS ---");
            supplierService.mapSuppliersToEssentials();
            System.out.println("--- DONE MAPPING SUPPLIERS TO ESSENTIALS ---");
        }
    }

    private void mapDirectAcquisitionContractsToEssentials() {
        if (MAP_DIRECT_ACQUISITION_CONTRACTS_TO_ESSENTIALS) {
            System.out.println("--- MAPPING DIRECT ACQUISITION CONTRACTS TO ESSENTIALS ---");
            directAcquisitionContractFetchService.mapDirectAcquisitionsToEssentials();
            System.out.println("--- DONE MAPPING DIRECT ACQUISITION CONTRACTS TO ESSENTIALS ---");
        }
    }

    private void computeItemMeasurementClass() {
        if (COMPUTE_ITEM_MEASUREMENT_CLASS) {
            System.out.println("--- COMPUTING ITEM MEASUREMENT CLASSES ---");
            itemMeasurementService.addItemMeasurementClassToAllContractItems();
            System.out.println("--- DONE COMPUTING ITEM MEASUREMENT CLASSES ---");
        }
    }

    private void computeContractsTotalSpendingByType() {
        if (COMPUTE_TOTAL_CONTRACTS_SPENDING_BY_TYPE) {
            System.out.println("--- COMPUTING CONTRACTS TOTAL SPENDING BY TYPE ---");
            contractsTotalSpendingByTypeService.computeContractsTotalSpendingByType();
            System.out.println("--- DONE COMPUTING CONTRACTS TOTAL SPENDING BY TYPE ---");
        }
    }

    private void computeContractingAuthoritiesTotalSpendingByType() {
        if (COMPUTE_CONTRACTING_AUTHORITIES_TOTAL_SPENDING_BY_TYPE) {
            System.out.println("--- COMPUTING CONTRACTING AUTHORITY SPENDING BY TYPE ---");
            contractsTotalSpendingByTypeService.computeContractsTotalSpendingByTypeForContractingAuthorities();
            System.out.println("--- DONE COMPUTING CONTRACTING AUTHORITY SPENDING BY TYPE ---");
        }
    }

    private void computeSuppliersTotalSpendingByType() {
        if (COMPUTE_SUPPLIERS_TOTAL_SPENDING_BY_TYPE) {
            System.out.println("--- COMPUTING SUPPLIER SPENDING BY TYPE ---");
            contractsTotalSpendingByTypeService.computeContractsTotalSpendingByTypeForSuppliers();
            System.out.println("--- DONE COMPUTING SUPPLIER SPENDING BY TYPE ---");
        }
    }

    private CpvSimpleTreeNode computeCpvTree() {
        if (COMPUTE_CPV_TREE) {
            System.out.println("--- COMPUTING CPV TREE ---");
            CpvSimpleTreeNode cpvSimpleTreeNode = cpvTreeConstructorService.constructCpvCodesTree();
            System.out.println("--- DONE COMPUTING CPV TREE ---");
            return cpvSimpleTreeNode;
        }
        return null;
    }

    private void computeNationalCpvData(CpvSimpleTreeNode root) {
        if (COMPUTE_NATIONAL_CPV_DATA) {
            System.out.println("--- COMPUTING NATIONAL CPV DATA TREE ---");
            cpvDataService.computeNationalCpvData(root);
            System.out.println("--- DONE COMPUTING NATIONAL CPV DATA TREE ---");
        }
    }

    private void computeContractingAuthorityCpvData(CpvSimpleTreeNode root) {
        if (COMPUTE_CONTRACTING_AUTHORITY_CPV_DATA) {
            System.out.println("--- COMPUTING CONTRACTING AUTHORITY CPV DATA TREE ---");
            cpvDataService.computeContractingAuthorityCpvData(root);
            System.out.println("--- DONE COMPUTING CONTRACTING AUTHORITY CPV DATA TREE ---");
        }
    }

    private void computeSupplierCpvData(CpvSimpleTreeNode root) {
        if (COMPUTE_SUPPLIER_CPV_DATA) {
            System.out.println("--- COMPUTING SUPPLIER CPV DATA TREE ---");
            cpvDataService.computeSupplierCpvData(root);
            System.out.println("--- DONE COMPUTING SUPPLIER CPV DATA TREE ---");
        }
    }

    private void computeExtraInformationFromOpenApiData() {
        if (COMPUTE_SUPPLIER_AVERAGE_REVENUE_FROM_PUBLIC_INSTITUTION_PER_YEAR_AND_EMPLOYEE_COUNT) {
            System.out.println("--- COMPUTING SUPPLIER AVERAGE FROM PUBLIC INSTITUTION PER YEAR AND EMPLOYEE COUNT ---");
            supplierService.computeExtraInformationFromOpenApiData();
            System.out.println("--- DONE COMPUTING SUPPLIER AVERAGE FROM PUBLIC INSTITUTION PER YEAR AND EMPLOYEE COUNT ---");
        }
    }
}
