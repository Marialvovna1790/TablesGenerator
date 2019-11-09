package data.columns;

import data.Gender;


public class GenderColumn implements TestDataColumn {

    private Gender gender;

    public GenderColumn(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String getValue() {
        return gender.toString();
    }

    @Override
    public String getHeaderName() {
        return "Пол";
    }
}
