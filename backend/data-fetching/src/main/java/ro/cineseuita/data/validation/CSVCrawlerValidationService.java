package ro.cineseuita.data.validation;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContract;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.data.shared.XlsUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class CSVCrawlerValidationService {

    private final Map<Integer, String> columnMapping;
    private final DirectAcquisitionContractRepository directAcquisitionContractRepository;

    @Autowired
    public CSVCrawlerValidationService(DirectAcquisitionContractRepository directAcquisitionContractRepository) {
        this.directAcquisitionContractRepository = directAcquisitionContractRepository;

        columnMapping = new HashMap<>();
        columnMapping.put(1, "supplierName");
        columnMapping.put(2, "supplierId");
        columnMapping.put(3, "supplierCountry");
        columnMapping.put(4, "supplierCity");
        columnMapping.put(5, "supplierAddress");
        columnMapping.put(6, "procedureType");
        columnMapping.put(7, "contractingAuthorityName");
        columnMapping.put(8, "contractingAuthorityId");
        columnMapping.put(9, "contractId");
        columnMapping.put(10, "contractPublishingDate");
        columnMapping.put(11, "description");
        columnMapping.put(12, "contractClosingType");
        columnMapping.put(13, "contractNumber");
        columnMapping.put(14, "contractDate");
        columnMapping.put(15, "contractTitle");
        columnMapping.put(16, "contractValue");
        columnMapping.put(17, "currency");
        columnMapping.put(18, "contractValueRon");
        columnMapping.put(19, "contractValueEur");
        columnMapping.put(20, "cpvCodeId");
        columnMapping.put(21, "cpvCode");
    }

    public void parseCSVToBeanList() throws IOException, InvalidFormatException {

        File f = new File("src/main/resources/direct/2018/achizitiidirecte2018t2.xlsx");
        InputStream is = new FileInputStream(f);

        // Finds the workbook instance for XLSX file
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);            // InputStream or File for XLSX file (required)


        Sheet mySheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = mySheet.iterator();
        rowIterator.next(); // skip header row

        List<DirectAcquisitionCSVContract> csvContracts = new ArrayList<>();

        int contracts = 0;
        int valid = 0;
        int invalid = 0;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            DirectAcquisitionCSVContract csvContract = formContractFromRow(row);
            if (validateCsvContract(csvContract)) {
                valid++;
            } else {
                invalid++;
            }
            csvContracts.add(csvContract);

        }

        System.out.println("total: " + contracts);
        System.out.println("valid: " + valid);
        System.out.println("invalid: " + invalid);

    }

    private boolean validateCsvContract(DirectAcquisitionCSVContract csvContract) {
        String contractId = csvContract.getContractId();
        DirectAcquisitionContract existingContract = directAcquisitionContractRepository.findByUniqueIdentificationCode(contractId);
        if (existingContract == null) {
            System.out.println("Contract id " + contractId + " not found");
            return false;
        } else {
            return validateDeep(csvContract, existingContract);
        }
    }

    private boolean validateDeep(DirectAcquisitionCSVContract csvContract, DirectAcquisitionContract existingContract) {
        // sufficiently deep conditions
        boolean valid = ((csvContract.getContractValue().equals(existingContract.getClosingValue())) || csvContract.getContractValue().equals(existingContract.getEstimatedValueRon())) &&
                existingContract.getSupplier().contains(csvContract.getSupplierName()) &&
                existingContract.getSupplier().contains(csvContract.getSupplierId()) &&
                existingContract.getContractingAuthority().contains(csvContract.getContractingAuthorityName()) &&
                existingContract.getContractingAuthority().contains(csvContract.getContractingAuthorityId()) &&
                existingContract.getCpvCode().contains(csvContract.getCpvCode()) &&
                existingContract.getDirectAcquisitionName().equals(csvContract.getContractTitle());
        if (!valid) {
            System.out.println("Problems found with DA: " + csvContract.getContractId());
            if (!((csvContract.getContractValue().equals(existingContract.getClosingValue())) || csvContract.getContractValue().equals(existingContract.getEstimatedValueRon()))) {
                System.out.println("Problem with value, expected: " + existingContract.getClosingValue() + " actual: " + csvContract.getContractValue());
            }
            if (!(existingContract.getSupplier().contains(csvContract.getSupplierName()) || existingContract.getSupplier().contains(csvContract.getSupplierId()))) {
                System.out.println("Problem with supplier, expected: " + existingContract.getSupplier() + " actual: " + csvContract.getSupplierName() + " " + csvContract.getSupplierId());
            }
            if (!(existingContract.getContractingAuthority().contains(csvContract.getContractingAuthorityName()) &&
                    existingContract.getContractingAuthority().contains(csvContract.getContractingAuthorityId()))) {
                System.out.println("Problem with CA, expected: " + existingContract.getContractingAuthority() + " actual: " + csvContract.getContractingAuthorityName() + " " + csvContract.getContractingAuthorityId());
            }
            if (!(existingContract.getCpvCode().contains(csvContract.getCpvCode()))) {
                System.out.println("Problem with CPV, expected: " + existingContract.getCpvCode() + " actual: " + csvContract.getCpvCode());
            }
            if (!existingContract.getDirectAcquisitionName().equals(csvContract.getContractTitle())) {
                System.out.println("Problem with title, expected: " + existingContract.getDirectAcquisitionName() + " actual: " + csvContract.getContractTitle());
            }
        }
        return valid;
    }

    private DirectAcquisitionCSVContract formContractFromRow(Row row) {
        DirectAcquisitionCSVContract contract = new DirectAcquisitionCSVContract();

        XlsUtilities.fillObjectFromRow(columnMapping, row, contract);
        return contract;
    }


}
