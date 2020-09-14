package ro.cineseuita.shared;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public class XlsUtilities {

    public static void fillObjectFromRow(Map<Integer, String> columnMapping, Row row, Object object) {
        Iterator<Cell> cellIterator = row.cellIterator();
        int columnNumber = 1;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            setContractFieldFromCell(columnMapping, object, columnNumber, cell);
            columnNumber++;
        }
    }

    private static void setContractFieldFromCell(Map<Integer, String> columnMapping, Object object, int columnNumber, Cell cell) {
        String fieldName = columnMapping.get(columnNumber);
        switch (cell.getCellType()) {
            case STRING:
                setField(object, fieldName, cell.getStringCellValue());
                break;
            case NUMERIC:
                setField(object, fieldName, cell.getNumericCellValue());
                break;
            case BOOLEAN:
                setField(object, fieldName, cell.getBooleanCellValue());
                break;
            default:
        }
    }

    private static void setField(Object targetObject, String fieldName, Object fieldValue) {
        Field field;
        try {
            field = targetObject.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            field = null;
        }
        Class superClass = targetObject.getClass().getSuperclass();
        while (field == null && superClass != null) {
            try {
                field = superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                superClass = superClass.getSuperclass();
            }
        }
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(targetObject, fieldValue);
        } catch (IllegalAccessException e) {
        }
    }
}
