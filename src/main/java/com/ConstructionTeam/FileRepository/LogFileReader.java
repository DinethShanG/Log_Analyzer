package com.ConstructionTeam.FileRepository;

import com.ConstructionTeam.DataModels.DateTime;
import com.ConstructionTeam.DataModels.ErrorData;
import com.ConstructionTeam.DataModels.ErrorDataCollector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class LogFileReader{
    public ArrayList<ErrorData> getData(String path, String previousAccessedDateTime, String LastAccessFilePath){

        String line = null;
        DateTime dateTime = new DateTime();
        String currentDateTime = dateTime.getCuurentDateTime();
        LastAccessFileWriter lastAccessFileWriter = new LastAccessFileWriter();
        ArrayList <ErrorData> errorDataList = new ArrayList<>();
        InputFileReader bufferFileReader = new FileReaderBuffered();
        BufferedReader bufferedReader= null;
        
        try {
            bufferedReader = bufferFileReader.readFile(path);
        } catch (IOException e) {
            System.out.println(" Log File not Founded");
        }
       catch (NullPointerException nullPointerException){
            System.out.print(" Log File not Founded");
            System.exit(0);
        }
        try {
            line = Objects.requireNonNull(bufferedReader).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lastDateTime = Objects.requireNonNull(line).substring(0, line.indexOf(","));
                    while (line != null) {
                        if (previousAccessedDateTime !=null){
                            try {
                                if (line.contains("ERROR") && dateTime.formatDateTime(lastDateTime).after(dateTime.formatDateTime(previousAccessedDateTime))) {
                                    ErrorDataCollector errorDataCollector = new ErrorDataCollector();
                                    errorDataCollector.collectErrorData(errorDataList,line);
                                }
                            } catch (ParseException e) {
                                System.out.println("Invalid Date Time Format");
                                lastAccessFileWriter.updateLastAccessDateTime(currentDateTime,LastAccessFilePath);
                                System.exit(0);
                            }
                        }
                        else {
                            if (line.contains("ERROR")) {
                                ErrorDataCollector errorDataCollector = new ErrorDataCollector();
                                errorDataCollector.collectErrorData(errorDataList,line);
                            }
                        }

                        try {
                            line = bufferedReader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    lastAccessFileWriter.updateLastAccessDateTime(currentDateTime,LastAccessFilePath);
                    return errorDataList;
            }
        }
