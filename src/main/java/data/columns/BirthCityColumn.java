package data.columns;

import data.DataFile;
import data.DataProvider;


public class BirthCityColumn extends RandomItemFromProviderColumn {

    public BirthCityColumn(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    protected DataFile getDataFile() {
        return DataFile.CITIES;
    }

    @Override
    public String getHeaderName() {
        return "Место рождения";
    }
}
