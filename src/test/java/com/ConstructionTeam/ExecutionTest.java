package com.ConstructionTeam;

import com.ConstructionTeam.DataModels.ErrorData;
import com.ConstructionTeam.DataModels.User;
import com.ConstructionTeam.DatabaseRepository.MySQL_CRUDOperator;
import com.ConstructionTeam.EmailRepository.EmailBodyCreator;
import com.ConstructionTeam.EmailRepository.MailgunEmailSender;
import com.ConstructionTeam.FileRepository.LastAccessFileReader;
import com.ConstructionTeam.FileRepository.LogFileReader;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ExecutionTest {
    @Test
    public void should_fetch_file_path_from_UI() throws IOException, SQLException {
        UI ui= mock(UI.class);
        LastAccessFileReader lastAccessFileReader = mock(LastAccessFileReader.class);
        LogFileReader logFileReader = mock(LogFileReader.class);
        MySQL_CRUDOperator mySQL_crudOperator=mock(MySQL_CRUDOperator.class);
        EmailBodyCreator emailBodyCreator = mock(EmailBodyCreator.class);
        MailgunEmailSender mailgunEmailSender = new MailgunEmailSender();


        when(ui.executeUI()).thenReturn("DummyFilePath");
        //when(lastAccessFileReader.getLastAccessDateTime("DummyFilePath")).thenReturn("DummyLastDateAndTime");

        ArrayList<ErrorData> errorDataList = new ArrayList<>();
        //errorDataList.add(new ErrorData("DummyCurrentDateAndTime","DummyId","DummyTitle","DummyDescription"));
        //when(logFileReader.getData("DummyFilePath","DummyLastDateAndTime")).thenReturn(errorDataList);

        ArrayList<User> userList=new ArrayList<>();
        userList.add(new User("DummyName","DummyEmail"));
        when(mySQL_crudOperator.getUserMailList()).thenReturn(userList);

        StringBuilder EmailBody = new StringBuilder("DummyBody");
        when(emailBodyCreator.createMailBody(errorDataList)).thenReturn(EmailBody);

        Execution execution=new Execution();
        execution.excute();
        verify(ui).executeUI();
    }
}