package data.columns;


public class YearColumn extends NumberColumn {

    public YearColumn(int value) {
        super(value);
    }

    @Override
    public String getHeaderName() {
        return "Возраст";
    }
}
