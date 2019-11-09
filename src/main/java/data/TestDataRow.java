package data;

import data.columns.TestDataColumn;

import java.util.List;

public class TestDataRow {

    private final List<? extends TestDataColumn> dataColumns;

    public TestDataRow(List<? extends TestDataColumn> dataColumns) {
        this.dataColumns = dataColumns;
    }

    public List<? extends TestDataColumn> getColumns() {
        return dataColumns;
    }
}
