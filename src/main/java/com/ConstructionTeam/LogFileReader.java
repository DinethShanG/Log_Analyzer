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
                int index=data.indexOf(errorKeyWord);
                if (index != -1) {
                    //System.out.println("finded" +data);
                    String[] spaceBraker =data.split(" ",3);// divide by space
                        String[] commaBraker =spaceBraker[1].split(",",10); // divide by comma
                        String[] dashBraker =spaceBraker[2].split("-",10);  // divide by dash

                    System.out.println();
                    
                    errorResult.date=spaceBraker[0];
                    errorResult.time = commaBraker[0];
                    errorResult.errorTree=dashBraker[1];
                    errorResult.errorDescription=dashBraker[2];

                    results.add(errorResult);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return results;
    }



}
