package com.ConstructionTeam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public final static String LASTACCESSFILENAME="LastAccess.txt";

    public static void main(String[] args) throws ParseException {

        String fileTimeStamp;


        LastAccessFileReader lastAccessFileReader=new LastAccessFileReader();
        fileTimeStamp=lastAccessFileReader.FileReader();

        LogFileReader logFileReader=new LogFileReader();
        List<ErrorResult> results =logFileReader.logFileReader("/media/shaggy/New Volume/project/Java/construction_final/Log_Analyzer/idea.log",fileTimeStamp);

        System.out.println("--------------------------------------------------------------------------------------");
        for (ErrorResult result:results) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Des"+result.getErrorDescription());
            System.out.println("Tree"+result.getErrorTree());
            System.out.println("Date"+result.getDate());
            System.out.println("Time"+result.getTime());
            System.out.println("--------------------------------------------------------------------------------------");

        }
        System.out.println("--------------------------------------------------------------------------------------");


        CurrentDateAndTime currentDateAndTime=new CurrentDateAndTime();
        LastAccessFileWriter lastAccessFileWriter=new LastAccessFileWriter();
        lastAccessFileWriter.writeFile(currentDateAndTime.getCurrentDateAndTime());






    }
}
