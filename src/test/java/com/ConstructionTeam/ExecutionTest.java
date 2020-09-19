package com.ConstructionTeam;

import com.ConstructionTeam.DataModels.ErrorData;
import com.ConstructionTeam.DataModels.User;
import com.ConstructionTeam.DatabaseRepository.MySQL_CRUDOperator;
import com.ConstructionTeam.EmailRepository.EmailBodyCreator;
import com.ConstructionTeam.EmailRepository.MailgunEmailSender;
import com.ConstructionTeam.FileRepository.LastAccessFileReader;
import com.ConstructionTeam.FileRepository.LogFileReader;
import com.ConstructionTeam.UserInterface.UI;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

public class ExecutionTest {

    Execution execution= new Execution();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    @Test
    public void should_fetch_file_path_from_UI() throws IOException, SQLException {
        systemInMock.provideLines("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log");

        Execution execution = new Execution();

        UI ui=mock(UI.class);
        when(ui.executeUI()).thenReturn("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log");

        LastAccessFileReader lastAccessFileReader = mock(LastAccessFileReader.class);
        when(lastAccessFileReader.getLastAccessDateTime("src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt")).thenReturn("2020-09-19 11:34:43");

        LogFileReader logFileReader = mock(LogFileReader.class);
        ArrayList<ErrorData> errorDataList = new ArrayList<>();
        errorDataList.add(new ErrorData());
        when(logFileReader.getData("src/test/java/com/ConstructionTeam/FileRepository/LogFileReaderTest.log","2020-09-19 11:34:43","src/main/java/com/ConstructionTeam/FileRepository/LastAccessDateTime.txt")).thenReturn(errorDataList);

        MySQL_CRUDOperator mySQL_crudOperator=mock(MySQL_CRUDOperator.class);
        ArrayList<User> userList=new ArrayList<>();
        userList.add(new User("DummyName","DummyEmail"));
        when(mySQL_crudOperator.getUserMailList()).thenReturn(userList);

        EmailBodyCreator emailBodyCreator = mock(EmailBodyCreator.class);
        StringBuilder EmailBody = new StringBuilder("DummyBody");
        when(emailBodyCreator.createMailBody(errorDataList)).thenReturn(EmailBody);

        MailgunEmailSender mailgunEmailSender = new MailgunEmailSender();

        execution.excute();
    }
}