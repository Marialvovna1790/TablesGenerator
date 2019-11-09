package data;

import java.util.List;

public interface DataGenerator {
    List<TestDataRow> generateData(int count);
}
