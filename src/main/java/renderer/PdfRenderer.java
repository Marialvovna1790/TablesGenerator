package renderer;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import data.TestDataRow;
import data.columns.TestDataColumn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class PdfRenderer implements TestDataRenderer {

    private final String fileName;
    private final Font font;

    public PdfRenderer(String fileName) {
        this.fileName = fileName;
        this.font = getFont();
    }

    @Override
    public void render(List<TestDataRow> rowList) {
        Document document = createDocument();

        List<? extends TestDataColumn> columns = rowList.get(0).getColumns();
        PdfPTable table = new PdfPTable(columns.size());
        table.setTotalWidth(PageSize.A2.getWidth()); table.setLockedWidth(true);
        addTableHeader(table, columns);
        addRows(table, rowList);

        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
        System.out.println("Pdf файл создан. Путь: " + new File(fileName).getAbsolutePath());
    }

    private Document createDocument() {
        Document document = new Document(PageSize.A2);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        document.open();
        return document;
    }

    private Font getFont() {
        try {
            String file = PdfRenderer.class.getClassLoader().getResource("Roboto-Regular.ttf").getFile();
            BaseFont bf = BaseFont.createFont(file,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            return new Font(bf);
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Can't find font", e);
        }
    }

    private void addRows(PdfPTable table, List<TestDataRow> rows) {
        for (TestDataRow row : rows) {
            for (TestDataColumn column : row.getColumns()) {
                table.addCell(new Phrase(column.getValue(), font));
            }
        }
    }

    private void addTableHeader(PdfPTable table, List<? extends TestDataColumn> columns) {
        columns.forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle.getHeaderName(), font));
            table.addCell(header);
        });
    }
}
