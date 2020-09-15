package com.ConstructionTeam;

import com.ConstructionTeam.DataModels.ErrorData;
import com.ConstructionTeam.DataModels.User;
import com.ConstructionTeam.DatabaseRepository.MySQL_CRUDOperator;
import com.ConstructionTeam.EmailRepository.EmailBodyCreator;
import com.ConstructionTeam.EmailRepository.MailgunEmailSender;
import com.ConstructionTeam.FileRepository.LastAccessFileReader;
import com.ConstructionTeam.FileRepository.LogFileReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Code Start Here
        String logFilePath, lastAccessFilePath, lastAccessDateTime = new String();
        // Scanner scanner = new Scanner(System.in);
        //System.out.print("Please Enter the Log File path:");
        //scanner.next(logFilePath);
        logFilePath = "/home/dsgimhana/Documents/Local Repository/Log_Analyzer/src/main/java/log_data.log";
        lastAccessFilePath = "src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt";
        // Last Access file Read
        LastAccessFileReader lastAccessFileReader = new LastAccessFileReader();
        try {
            lastAccessDateTime = lastAccessFileReader.getLastAccessDateTime(lastAccessFilePath);
        } catch (IOException e) {
            System.out.println("Issue in Last Access Date Time File");
        }
        // Log file Read
        LogFileReader logFileReader = new LogFileReader();
        ArrayList<ErrorData> errorList;
        errorList = logFileReader.getData(logFilePath,lastAccessDateTime);

        // Get Mail List
        ArrayList <User> userDetails = new ArrayList<>();
        try {
            userDetails = new MySQL_CRUDOperator().getUserMailList();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        EmailBodyCreator emailBodyCreater = new EmailBodyCreator();
        StringBuilder emailBody = emailBodyCreater.createMailBody(errorList);
        MailgunEmailSender mailgunEmailSender = new MailgunEmailSender();
        for (User user : userDetails) {
            mailgunEmailSender.sendSimpleMessage(user,emailBody);
        }

    }
}
