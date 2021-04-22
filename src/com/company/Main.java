package com.company;


import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileHandler firstHandler = new FileHandler();
        firstHandler.setFilePath(firstHandler.readStringFromUser());
        firstHandler.writeToFile(firstHandler.getStoragePath(), firstHandler.getFilePath());
        while(true)
        {
                System.out.println( firstHandler.readCharactersFromFile(new File(firstHandler.getFilePath())) );
                firstHandler.readLine();
        }
    }

}
