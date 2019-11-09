package data.columns;


public class ApartmentColumn extends RandomNumberColumn {
    public ApartmentColumn(int from, int to) {
        super(from, to);
    }

    @Override
    public String getHeaderName() {
        return "Квартира";
    }
}
