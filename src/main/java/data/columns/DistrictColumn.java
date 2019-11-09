package data.columns;

import data.DataFile;
import data.DataProvider;


public class DistrictColumn extends RandomItemFromProviderColumn{
    public DistrictColumn(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    protected DataFile getDataFile() {
        return DataFile.DISTRICTS;
    }

    @Override
    public String getHeaderName() {
        return "Область";
    }
}
