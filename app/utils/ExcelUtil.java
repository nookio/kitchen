package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by houchen on 16/11/29.
 */
public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    private static final String XLS = ".xls";
    private static final String XLSX = ".xlsx";

    private static final String PARAM_ERROR = "参数错误";
    private static final String SUFFIX_ERROR = "文件后缀错误";
    private static final String TITLE_ERROR = "文件与模板不符，顶端标题行不一致";
    private static final String TOO_MUCH = "数据列表过大，最多为65534个";

    //读Excel文件到List
    public static <T> List<T> read(LinkedHashMap<String, String> cellName2fieldName, File file, Class<T> clazz) throws Exception {
        if(cellName2fieldName == null || file == null || clazz == null) throw new RuntimeException(PARAM_ERROR);
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if (!suffix.equals(XLS) && !suffix.equals(XLSX)) throw new RuntimeException(SUFFIX_ERROR);

        List<T> objects = new ArrayList<T>();
        Workbook wb = suffix.equals(XLS) ? new HSSFWorkbook(new FileInputStream(file)) : new XSSFWorkbook(new FileInputStream(file));
        Sheet sheet = wb.getSheetAt(0);//默认用第一个sheet
        if (!checkTitle(cellName2fieldName, sheet)) throw new RuntimeException(TITLE_ERROR);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {// 循环读取 忽略第一行
            Row row = sheet.getRow(i);
            if (row == null) continue;
            T entity = genEntity(cellName2fieldName, row, clazz);
            if (entity == null) continue;
            objects.add(entity);
        }
        return objects;
    }

    private static Boolean checkTitle(LinkedHashMap<String, String> cellName2fieldName, Sheet sheet) {
        Row title = sheet.getRow(0);
        List<String> cellNames = new ArrayList<>(cellName2fieldName.keySet());
        for (int i = 0; i < cellNames.size(); i++) {
            String titleName = (String) getCellValue(title.getCell(i));
            if (!cellNames.get(i).equals(titleName)) return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static <T> T genEntity(HashMap<String, String> cellName2fieldName, Row row, Class<T> clazz) throws Exception {
        T entity = null;
        List<String> cellNames = new ArrayList<>(cellName2fieldName.keySet());
        HashMap<String, Field> name2field = new HashMap<>();
        for (int i = 0; i < cellNames.size(); i++) {
            Cell cell = row.getCell(i);
            if (cell == null) continue;
            Object object = getCellValue(cell);
            if (object == null) continue;
            String fieldName = cellName2fieldName.get(cellNames.get(i));
            if (StringUtils.isBlank(fieldName)) continue;

            entity = entity == null ? clazz.newInstance() : entity;
            Field field = name2field.get(fieldName);
            if (field == null) {
                field = entity.getClass().getDeclaredField(fieldName);
                name2field.put(fieldName, field);
            }
            //执行set方法
            setField(entity.getClass(), entity, "set" + StringUtils.capitalize(fieldName), new Class[]{field.getType()}, new Object[]{object});
        }
        return entity;
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC: return cell.getNumericCellValue();
            case Cell.CELL_TYPE_BOOLEAN: return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_FORMULA: return cell.getCellFormula();
            case Cell.CELL_TYPE_ERROR: return cell.getErrorCellValue();
            case Cell.CELL_TYPE_BLANK: return StringUtils.EMPTY;
            default: return null;
        }
    }

    private static void setField(Class clazz, Object object, String methodName, Class[] paramTypes, Object[] args) {
        try {
            Method method = ReflectionUtils.findMethod(clazz, methodName, paramTypes);
            ReflectionUtils.invokeMethod(method, object, args);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
    }

    private static final int MAX_SIZE = 65534;

    //写List到Excel文件
    public static <T> void write(LinkedHashMap<String, String> fieldName2cellName, List<T> objects, Class<T> clazz, OutputStream outputStream) throws Exception {
        if(fieldName2cellName == null || objects == null || clazz == null) throw new RuntimeException(PARAM_ERROR);
        if (objects.size() > MAX_SIZE) throw new IllegalArgumentException(TOO_MUCH);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet();
        XSSFRow xssfRow = xssfSheet.createRow(0);
        List<String> filedNames = new ArrayList<>(fieldName2cellName.keySet());
        for (int i = 0; i < filedNames.size(); i++) {
            String titleName = fieldName2cellName.get(filedNames.get(i));
            if (StringUtils.isBlank(titleName)) continue;
            xssfRow.createCell(i).setCellValue(titleName);
        }

        int countRow = 1;
        for (T object : objects) {
            if (object == null) continue;
            xssfRow = xssfSheet.createRow(countRow++);
            for (int i = 0; i < filedNames.size(); i++) {
                XSSFCell xssfCell = xssfRow.createCell(i);
                String result = getField(object.getClass(), object, "get" + StringUtils.capitalize(filedNames.get(i)), new Class[]{}, new Object[]{});
                xssfCell.setCellValue(result);
            }
        }
        xssfWorkbook.write(outputStream);
    }

    private static String getField(Class clazz, Object object, String methodName, Class[] paramTypes, Object[] args) {
        try {
            Method method = ReflectionUtils.findMethod(clazz, methodName, paramTypes);
            return (String) ReflectionUtils.invokeMethod(method, object, args);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return StringUtils.EMPTY;
        }
    }

}
