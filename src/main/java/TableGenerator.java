import data.DataProvider;
import data.PeopleDataGenerator;
import data.TestDataRow;
import renderer.ConsoleRenderer;
import renderer.ExcelRenderer;
import renderer.PdfRenderer;
import renderer.TestDataRenderer;

import java.util.List;

public class TableGenerator {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите число строк от 1 до 30");
            System.exit(1);
        }
        int num = Integer.parseInt(args[0]);
        if (num < 0 || num > 30) throw new IllegalArgumentException("Число должно быть в диапазоне [1, 30]");

        List<TestDataRow> dataRows = new PeopleDataGenerator(new DataProvider()).generateData(num);
        TestDataRenderer[] renderers = new TestDataRenderer[]{
                new ConsoleRenderer(),
                new ExcelRenderer("People.xls"),
                new PdfRenderer("People.pdf")
        };

        for (TestDataRenderer renderer : renderers) {
            renderer.render(dataRows);
        }
    }
}
