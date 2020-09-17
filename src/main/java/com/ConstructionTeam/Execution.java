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

public class Execution {
    public void excute(){

        String logFilePath;
        UI ui = new UI();
        logFilePath = ui.executeUI();

        // Code Start Here
        String lastAccessDateTime = new String();
        // Last Access file Read
        LastAccessFileReader lastAccessFileReader = new LastAccessFileReader();
        try {
            lastAccessDateTime = lastAccessFileReader.getLastAccessDateTime("src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        EmailBodyCreator emailBodyCreater = new EmailBodyCreator();
        StringBuilder emailBody = emailBodyCreater.createMailBody(errorList);
        if(emailBody == null){
            System.out.println("No Errors Found");
        }
        else {
            MailgunEmailSender mailgunEmailSender = new MailgunEmailSender();
            for (User user : userDetails) {
                mailgunEmailSender.sendSimpleMessage(user, emailBody);
            }
        }
    }
}
