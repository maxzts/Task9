package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.rmi.server.LogStream.log;

public class Main {

    public static void main(String[] args) {


            Person person1 = new Person("Garry", "Potter", new Address("Little Whinging", " Privet Drive", 4));
            Person person2 = new Person("Hermione", "Granger", new Address("London", " Heathgate", 9));
            Person person3 = new Person("Ron", "Weasley", new Address("Ottery St Catchpole", "the Burrow ",1));
            System.out.println(person1 + "\n" + person2 + "\n" + person3);

            try{
                person1.findNullFieldException();
                person2.findNullFieldException();
                person3.findNullFieldException();
                System.out.println("Поля всех проверяемых объектов заполнены верно.");
            } catch (NullFieldException e){
                System.out.print(e.getMessage());
            }

            List<Person> persons = new ArrayList<>();
            persons.add(person1);
            persons.add(person2);
            persons.add(person3);

            PersonIOUtil personIOUtil = new PersonIOUtil();
            try{
                personIOUtil.writePerson("E:\\javaDz9\\data.csv", persons);
                System.out.println("\nОбъекты записаны в файл");
            } catch (IOException e){
                e.printStackTrace();
            }

        System.out.println();

            PersonIOUtil personIOUtil1 = new PersonIOUtil();
            try{

                List<Person> personsFromFile = personIOUtil1.readPerson("E:\\javaDz9\\data.csv");
                System.out.println(personsFromFile);

            } catch (FileNotFoundException e){
                System.out.println("Ошибка, файла не существует");

            } catch (IOException e){
                e.printStackTrace();

            } catch (EmptySourceFileException e){
                e.printStackTrace();
            }























    }
}
