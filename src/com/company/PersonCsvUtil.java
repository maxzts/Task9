package com.company;



public class PersonCsvUtil {
    public static final String DELIMITER = ";";
    public static final String[] HEADERS = {"First name", "Last name", "City", "Street", "House number" };

    public static String headers(){
        return String.join(DELIMITER, HEADERS) + "\n";
    }

    // Преобразование объекта Person к строке для записи в файл:
    public static String toCsvString (Person person){
        return person.getFirstname() + DELIMITER +
                person.getLastname() + DELIMITER +
                person.getAddress().getCity() + DELIMITER +
                person.getAddress().getStreet() + DELIMITER +
                person.getAddress().getHouseNumber() + "\n";
    }

    // Преобразование строки из csv-файла к объекту:
    public static Person toObject (String csvString) throws CsvException {
        String[] dataArray = csvString.split(DELIMITER);

        if (dataArray.length != 5) {
            String errorMassage = String.format(ExceptionMessageConstants.ERROR_MESSAGE_PATTERN, csvString);
            throw new CsvException(errorMassage);
        }

        String firstName = dataArray[0];
        String lastName = dataArray[1];
        String city = dataArray[2];
        String street = dataArray[3];
        int houseNumber = Integer.parseInt(dataArray[4]);


        return new Person(firstName, lastName,  new Address(city, street, houseNumber));



    }

}
