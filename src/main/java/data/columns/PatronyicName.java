package data.columns;

import data.DataProvider;
import data.Gender;


public class PatronyicName extends BaseGenderNameColumn {

    public static final int COLUMN_PATRONYIC = 2;

    public PatronyicName(Gender gender, DataProvider dataProvider) {
        super(dataProvider, gender);
    }

    @Override
    public String getHeaderName() {
        return "Отчество";
    }

    @Override
    protected int getColumnIndex() {
        return COLUMN_PATRONYIC;
    }
}
