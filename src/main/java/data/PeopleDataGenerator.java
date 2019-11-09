package data;

import data.columns.*;
import util.RandomDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class PeopleDataGenerator implements DataGenerator {

    private Random random = new Random();
    private RandomDate randomDate = new RandomDate(LocalDate.of(1930, 1, 1), LocalDate.of(2009, 1, 1));
    private final DataProvider dataProvider;
    private LocalDate localDate = LocalDate.now();

    public PeopleDataGenerator(DataProvider provider) {
        dataProvider = provider;
    }

    @Override
    public List<TestDataRow> generateData(int count) {
        ArrayList<TestDataRow> peopleDataEntries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
            LocalDate dateOfBirth = randomDate.nextDate();
            int yearsOld = (int) ChronoUnit.YEARS.between(dateOfBirth, localDate);

            List<TestDataColumn> dataColumns = Arrays.asList(
                    new NameColumn(gender, dataProvider),
                    new SurnameColumn(gender, dataProvider),
                    new PatronyicName(gender, dataProvider),
                    new YearColumn(yearsOld),
                    new GenderColumn(gender),
                    new DateColumn(dateOfBirth),
                    new BirthCityColumn(dataProvider),
                    new IndexColumn(118662, 968613),
                    new CountryColumn(),
                    new DistrictColumn(dataProvider),
                    new CityColumn(dataProvider),
                    new HouseColumn(1, 255),
                    new ApartmentColumn(1,255)
            );
            peopleDataEntries.add(new TestDataRow(dataColumns));
        }
        return peopleDataEntries;
    }
}
