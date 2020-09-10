package com.ConstructionTeam;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogFileReader {
    private String errorKeyWord="ERROR";

    public List<ErrorResult> logFileReader(String URL){
        List<ErrorResult> results=new ArrayList<ErrorResult>();

        try {
            File myObj = new File(URL);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int index=data.indexOf(errorKeyWord);

                if (index != -1) {
                    ErrorResult errorResult=new ErrorResult();

                    String[] spaceBraker =data.split(" ",3);// divide by space
                        String[] commaBraker =spaceBraker[1].split(",",10); // divide by comma
                        String[] dashBraker =spaceBraker[2].split("-",10);  // divide by dash
                    
                    errorResult.setDate(spaceBraker[0]);
                    errorResult.setTime(commaBraker[0]);
                    errorResult.setErrorTree(dashBraker[1]);
                    errorResult.setErrorDescription(dashBraker[2]);

                    results.add(errorResult);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        return results;
    }



}
