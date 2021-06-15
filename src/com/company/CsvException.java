package com.company;

public class CsvException extends Exception {

    // Исключение, которое имеет место при преобразовании строки из csv-файла к объекту

    public CsvException (String massage){
        super(massage);
    }



}
