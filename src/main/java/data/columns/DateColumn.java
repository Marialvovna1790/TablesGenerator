package data.columns;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateColumn implements TestDataColumn {

    private String value;

    public DateColumn(LocalDate dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        value = dateOfBirth.format(formatter);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getHeaderName() {
        return "Дата рождения";
    }
}
