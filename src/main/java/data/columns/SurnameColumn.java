package data.columns;

import data.DataProvider;
import data.Gender;


public class SurnameColumn extends BaseGenderNameColumn {

    public static final int COLUMN_SURNAME = 1;

    public SurnameColumn(Gender gender, DataProvider dataProvider) {
        super(dataProvider, gender);
    }

    @Override
    public String getHeaderName() {
        return "Фамилия";
    }

    @Override
    protected int getColumnIndex() {
        return COLUMN_SURNAME;
    }
}
