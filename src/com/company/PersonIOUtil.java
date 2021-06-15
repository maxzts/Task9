package com.company;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonIOUtil {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public static void writePerson (String fileName, List<Person> persons) throws IOException{
        try (FileWriter writer = new FileWriter(fileName)){
            writer.write(PersonCsvUtil.headers());
            for (Person person : persons){
                writer.write(PersonCsvUtil.toCsvString(person));
            }

        }
    }



    public static List<Person> readPerson (String fileName) throws IOException, EmptySourceFileException {

        List<Person> persons = new ArrayList<>();



        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            reader.readLine();

            if (reader.readLine() == null){
                throw new EmptySourceFileException("Ошибка, файл пуст!");
            }

            String csvString;

            while ((csvString = reader.readLine()) != null){
                Person person = PersonCsvUtil.toObject(csvString);
                persons.add(person);
            }

//
        } catch (CsvException e){
            e.printStackTrace();
        }
        return persons;

    }





}
