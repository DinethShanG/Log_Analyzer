package com.ConstructionTeam.FileRepository;

import com.ConstructionTeam.DataModels.ErrorData;
import com.ConstructionTeam.DataModels.ErrorDataCollector;
import com.ConstructionTeam.DataModels.ErrorDataModelCreator;

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
    public ArrayList<ErrorData> getData(String path, String previousAccessedDateTime){
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList <ErrorData> errorDataList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("Log File is not Founded");
        }
        try {
            if (bufferedReader == null){
                System.exit(0);
            }
            else if (bufferedReader.readLine() == null) {
                System.out.println("Log file is empty");
            }

            else {
                String line = null;
                try {
                    line = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert line != null;
                String lastDateTime = line.substring(0, line.indexOf(","));
                    while (line != null) {
                        if (previousAccessedDateTime !=null){
                            if (line.contains("ERROR") && sdf.parse(lastDateTime).after(sdf.parse(previousAccessedDateTime)) ) {
                                ErrorDataCollector errorDataCollector = new ErrorDataCollector();
                                errorDataCollector.collectErrorData(errorDataList,line);
                            }
                        }
                        else {
                            if (line.contains("ERROR")) {
                                ErrorDataCollector errorDataCollector = new ErrorDataCollector();
                                errorDataCollector.collectErrorData(errorDataList,line);
                            }
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
            assert bufferedReader != null;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LastAccessFileWriter lastAccessFileWriter = new LastAccessFileWriter();
        lastAccessFileWriter.updateLastAccessDateTime(currentDateTime);
        return errorDataList;


    }
}
