package data.columns;

import data.DataFile;
import data.DataProvider;


public class StreetColumn extends RandomItemFromProviderColumn{
    protected StreetColumn(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    protected DataFile getDataFile() {
        return DataFile.STREETS;
    }

    @Override
    public String getHeaderName() {
        return "Улица";
    }
}
