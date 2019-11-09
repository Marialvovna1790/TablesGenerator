package data.columns;

import data.DataProvider;
import data.Gender;



public class NameColumn extends BaseGenderNameColumn {
    public static final int COLUMN_NAME = 0;

    public NameColumn(Gender gender, DataProvider dataProvider) {
        super(dataProvider, gender);
    }

    @Override
    public String getHeaderName() {
        return "Имя";
    }

    @Override
    protected int getColumnIndex() {
        return COLUMN_NAME;
    }
}
