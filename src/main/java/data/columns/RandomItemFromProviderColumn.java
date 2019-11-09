package data.columns;

import data.DataFile;
import data.DataProvider;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public abstract class RandomItemFromProviderColumn implements TestDataColumn {

    private final DataProvider dataProvider;
    private String value;
    private Random random = new Random();

    protected RandomItemFromProviderColumn(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public String getValue() {
        if (value == null) {
            List<String> data = dataProvider.getData(getDataFile());
            value = pickItem(data);
        }
        return value;
    }

    protected String pickItem(List<String> items) {
        return items.get(random.nextInt(items.size()));
    }

    protected abstract DataFile getDataFile();
}
