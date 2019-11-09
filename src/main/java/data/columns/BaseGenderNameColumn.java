package data.columns;

import data.DataFile;
import data.DataProvider;
import data.Gender;

import java.util.List;


public abstract class BaseGenderNameColumn extends RandomItemFromProviderColumn {
    private Gender gender;

    public BaseGenderNameColumn(DataProvider dataProvider, Gender gender) {
        super(dataProvider);
        this.gender = gender;
    }

    @Override
    public String getValue() {
        return super.getValue().split(" ")[getColumnIndex()];
    }

    protected abstract int getColumnIndex();

    @Override
    protected DataFile getDataFile() {
        return gender == Gender.MALE ? DataFile.MALES : DataFile.FEMALES;
    }
}
