package data.columns;



public class CountryColumn implements TestDataColumn {

    @Override
    public String getValue() {
        return "Россия";
    }

    @Override
    public String getHeaderName() {
        return "Страна";
    }
}
