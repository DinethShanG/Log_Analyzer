package com.ConstructionTeam;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LogFileReader {
    private String errorKeyWord="ERROR";
    private boolean checkDate;

    public List<ErrorResult> logFileReader(String URL,String filetimeStamp) throws ParseException { //get the file url
        List<ErrorResult> results=new ArrayList<ErrorResult>();

        try {
            File myObj = new File(URL);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {     //read the file
                String data = myReader.nextLine();
                String[] sDateTime=data.split(",",2);


            if(filetimeStamp !=null && sDateTime !=null){
                Date dateTimeInLogFile=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDateTime[0]);         //convert to Date
                Date dateTimeInLastAccessFile=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(filetimeStamp);
                checkDate=dateTimeInLogFile.after(dateTimeInLastAccessFile);
            }
            else if (filetimeStamp==null){
                checkDate=true;
            }
            else{
                checkDate=false;
                System.out.println("Log file is not suitable for this application");
            }


                if (data.contains(errorKeyWord) && checkDate ) {               // find error in line by line
                    ErrorResult errorResult=new ErrorResult();

                    String[] spaceBraker =data.split(" ",3);
                        String[] commaBraker =spaceBraker[1].split(",",10);
                        String[] dashBraker =spaceBraker[2].split("-",10);

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
