package ro.cineseuita.cpv.service;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.cpv.entity.CpvCode;
import ro.cineseuita.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.cpv.repository.CpvCodesRepository;
import ro.cineseuita.shared.XlsUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class CpvCodesService {

    private static String CPV_REGEX = "/\\d{8}-\\d";
    private static Pattern REGEX_PATTERN = Pattern.compile(CPV_REGEX);

    private final Map<Integer, String> columnMapping;
    private final CpvCodesRepository cpvCodesRepository;
    private final Map<String, String> codesMappedFromSimple;


    @Autowired
    public CpvCodesService(CpvCodesRepository cpvCodesRepository) {
        this.cpvCodesRepository = cpvCodesRepository;
        columnMapping = new HashMap<>();
        columnMapping.put(1, "code");
        columnMapping.put(2, "description");
        codesMappedFromSimple = new HashMap<>();
    }

    private static boolean isInvalidCode(String code) {
        return REGEX_PATTERN.matcher(code).matches();
    }

    public void parseCpvCodesXls() throws FileNotFoundException {
        File f = new File("src/main/resources/cpv_2008.xlsx");
        InputStream is = new FileInputStream(f);

        // Finds the workbook instance for XLSX file
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);            // InputStream or File for XLSX file (required)

        Sheet mySheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = mySheet.iterator();
        rowIterator.next(); // skip header row

        List<CpvCode> cpvCodes = new ArrayList<>();


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            CpvCode cpvCode = formCpvCode(row);
            cpvCode.set_id(cpvCode.getCode());
            cpvCode.setCodeSimplified(cpvCode.getCode().substring(0, 8));
            cpvCodes.add(cpvCode);
        }
        cpvCodesRepository.saveAll(cpvCodes);
    }

    public String getParentCode(String code) {
        if (isInvalidCode(code)) {
            throw new RuntimeException("Invalid CPV code: " + code);
        }

        if (CpvCodeParentExceptions.hasSpecialParent(code)) {
            return CpvCodeParentExceptions.getSpecialParent(code);
        }

        String first8 = code.substring(0, 8);

        int indexOfFirstNonZeroDigit = 7;
        while (first8.charAt(indexOfFirstNonZeroDigit) == '0') {
            indexOfFirstNonZeroDigit--;
        }

        StringBuilder simplifiedCodeParentCode = new StringBuilder(first8.substring(0, indexOfFirstNonZeroDigit));
        while (simplifiedCodeParentCode.length() < 8) {
            simplifiedCodeParentCode.append("0");
        }

        String returnedCode = codesMappedFromSimple.get(simplifiedCodeParentCode.toString());
        if (returnedCode == null || returnedCode.equals(code)) {
            return CpvSimpleTreeNode.ROOT;
        } else {
            return returnedCode;
        }
    }

    public void assignParentCodes() {
        List<CpvCode> allCodes = cpvCodesRepository.findAll();
        formCodesMap(allCodes);
        allCodes.forEach(cpvCode -> {
            cpvCode.setParent(getParentCode(cpvCode.getCode()));
            cpvCodesRepository.save(cpvCode);
        });
    }

    private CpvCode formCpvCode(Row row) {
        CpvCode cpvCode = new CpvCode();
        XlsUtilities.fillObjectFromRow(columnMapping, row, cpvCode);
        return cpvCode;
    }

    private void formCodesMap(List<CpvCode> allCodes) {
        allCodes.forEach(cpvCode -> codesMappedFromSimple.put(cpvCode.getCodeSimplified(), cpvCode.getCode()));
    }

}
