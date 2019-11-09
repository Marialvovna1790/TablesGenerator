package data.columns;

import data.DataFile;
import data.DataProvider;


public class CityColumn extends RandomItemFromProviderColumn {
    public CityColumn(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    protected DataFile getDataFile() {
        return DataFile.CITIES;
    }

    @Override
    public String getHeaderName() {
        return "Город";
    }
}
