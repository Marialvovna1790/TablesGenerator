package renderer;

import data.TestDataRow;
import data.columns.TestDataColumn;

import java.util.List;


public class ConsoleRenderer implements TestDataRenderer {
    @Override
    public void render(List<TestDataRow> rowList) {
        System.out.println("---------------------");
        for (TestDataRow testDataRow : rowList) {
            testDataRow.getColumns().stream().map(TestDataColumn::getValue).forEach(v -> System.out.print(v + " "));
            System.out.println();
        }
        System.out.println("---------------------");
    }
}
