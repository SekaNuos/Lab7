package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadingFile
{
    void writeInFile(String fileName, ArrayList<Train> list)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            oos.writeObject(list);
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    ArrayList<Train> readFromFile(String fileName, ArrayList<Train> list)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {

            list=((ArrayList<Train>)ois.readObject());
            return list;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }
}
