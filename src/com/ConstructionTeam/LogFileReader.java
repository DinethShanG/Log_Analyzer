package com.ConstructionTeam;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogFileReader {
    private final String URL="/media/shaggy/New Volume/project/Java/construction_final/Log_Analyzer/idea.log";
    private String errorKeyWord="ERROR";

    public List logFileReader(){
    List<ErrorResult> results=new ArrayList<ErrorResult>();
    ErrorResult errorResult=new ErrorResult();
        try {
            File myObj = new File(URL);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                //String[] arrayOfString=data.split(",",5);

                results.add(errorResult);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return results;
    }



}
