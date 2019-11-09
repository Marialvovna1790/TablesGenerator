package data.columns;


public abstract class NumberColumn implements TestDataColumn {

    private int value;

    public NumberColumn(int value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
