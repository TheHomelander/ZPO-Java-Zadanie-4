package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileHandler {
    private String filePath;
    final private String pathStorageFilePath = "storageFilePath.txt";
    final int maxNumberOfCharacters = 5;
    final int minNumberOfCharacters = 1;


    protected String getFilePath()
    {
        return filePath;
    }

    protected void setFilePath(String newPath)
    {
        filePath = newPath;
    }

    protected String getStoragePath()
    {
        return pathStorageFilePath;
    }

    protected String readLine(){
        Scanner tempScan = new Scanner(System.in);
        return tempScan.nextLine();
    }

    protected String readStringFromUser()
    {

        try
        {
            Scanner scanInput = new Scanner(System.in);
            String readString;
            readString = scanInput.nextLine();
            return readString;

        }
        catch (NoSuchElementException ex)
        {

            System.out.println("Nie znaleziono lancucha do odczytu");

        }
        catch (IllegalStateException ex)
        {
            System.out.println("Objekt klasy Scanner nie istnieje");


        }
        return  null;
    }

    protected String readCharactersFromFile(File file)
    {
        try(InputStream input = new FileInputStream(file))
        {
            String bufferOut;
            StringBuilder sb = new StringBuilder();
            Reader myReader = new InputStreamReader(input, Charset.defaultCharset());
            int numberOfChars = returnRandomIntInRange(maxNumberOfCharacters, minNumberOfCharacters);
            int endCounter = 0;
            int buff;

            while (((buff = myReader.read()) != -1) && endCounter != numberOfChars)
            {
                sb.append((char) buff);
                endCounter++;
            }
            bufferOut = sb.toString();
            return bufferOut;

        }
        catch (IOException e)
        {
            System.out.println("Error in reading characters from file");
            e.printStackTrace();
        }
        return null;

    }

    private int returnRandomIntInRange(int max, int min)
    {
        return (int) (Math.random() * max + min);
    }

    protected boolean writeToFile(String pathToFile, String contentToSave)
    {
        boolean operationStatus = false;
        try {

        FileWriter writeToFileObj = new FileWriter(pathToFile);
        writeToFileObj.write(contentToSave);
        writeToFileObj.close();
        operationStatus = true;
        }
        catch (IOException e)
        {
            System.out.println("Error in writing Path to File");
            e.printStackTrace();
        }
        return operationStatus;
    }



}
