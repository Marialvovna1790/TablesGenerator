package renderer;

import data.TestDataRow;
import data.columns.TestDataColumn;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class ExcelRenderer implements TestDataRenderer {

    private String fileName;

    public ExcelRenderer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void render(List<TestDataRow> rowList) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Люди");

        List<? extends TestDataColumn> columns = rowList.get(0).getColumns();

        createHeader(workbook, sheet, columns);
        createRows(rowList, sheet);
        setAutoSize(sheet, columns);
        saveFile(workbook);
    }

    private void saveFile(Workbook workbook) {
        try {
            File file = new File(fileName);
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Excel файл создан. Путь: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setAutoSize(Sheet sheet, List<? extends TestDataColumn> columns) {
        for (int i = 0; i < columns.size(); i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private void createRows(List<TestDataRow> rowList, Sheet sheet) {
        for (int i = 0; i < rowList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            TestDataRow dataRow = rowList.get(i);
            List<? extends TestDataColumn> rowColumns = dataRow.getColumns();
            for (int j = 0; j < rowColumns.size(); j++) {
                row.createCell(j).setCellValue(rowColumns.get(j).getValue());
            }
        }
    }

    private void createHeader(Workbook workbook, Sheet sheet, List<? extends TestDataColumn> columns) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        for (int i = 0; i < columns.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns.get(i).getHeaderName());
            cell.setCellStyle(headerCellStyle);
        }
    }
}
