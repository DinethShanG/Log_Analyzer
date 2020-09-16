package com.ConstructionTeam.FileRepository;

import com.ConstructionTeam.DataModels.ErrorData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LogFileReader {
    public Date dateConversion(String strDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public ErrorData createErrorData(String line){
        ErrorData errorData = new ErrorData();
        errorData.setDateTime(line);
        errorData.setId(line);
        errorData.setTitleDescription(line);
        return errorData;
    }

    public ArrayList<ErrorData> getData(String path, String previousAccessedDateTime){
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList <ErrorData> errorDataList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader.readLine() == null) {
                System.out.println("No errors, and log file empty");
            }

            else {
                String line = null;
                try {
                    line = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String lastDateTime = line.substring(0, line.indexOf(","));
                    while (line != null) {
                        if (line.contains("ERROR") && sdf.parse(lastDateTime).after(sdf.parse(previousAccessedDateTime))) {
                            ErrorData errorData;
                            errorData = createErrorData(line);
                            errorDataList.add(errorData);
                        }
                        line = bufferedReader.readLine();
                        if(line!=null) {
                            lastDateTime = line.substring(0, line.indexOf(","));
                        }
                    }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LastAccessFileWriter lastAccessFileWriter = new LastAccessFileWriter();
        lastAccessFileWriter.updateLastAccessDateTime(currentDateTime);
        return errorDataList;


    }
}
