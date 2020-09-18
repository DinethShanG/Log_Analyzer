package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.ErrorData;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmailBodyCreatorTest {

    @Test
    public void should_return_email_body()
    {
        ArrayList<ErrorData> errorList=new ArrayList<>();
        errorList.add(new ErrorData("2020-01-25 16:16:51","15422630","j.psi.stubs.StubTreeLoaderImpl","Outdated stub in index: file://C:/Users/This PC/OneDrive/Desktop/projects/University_Management_System/"));
        errorList.add(new ErrorData("2020-01-25 16:16:51","15422630","j.psi.stubs.StubTreeLoaderImpl","IntelliJ IDEA 2019.3.1  Build #IU-193.5662.53"));

        EmailBodyCreator emailBodyCreator=new EmailBodyCreator();
        StringBuilder actualEmailBody=emailBodyCreator.createMailBody(errorList);

        StringBuilder expectedEmailBody = new StringBuilder("We have notified that there are 2 errors. More Details below, \n\n2020-01-25 16:16:51 - j.psi.stubs.StubTreeLoaderImpl - Outdated stub in index: file://C:/Users/This PC/OneDrive/Desktop/projects/University_Management_System/\n2020-01-25 16:16:51 - j.psi.stubs.StubTreeLoaderImpl - IntelliJ IDEA 2019.3.1  Build #IU-193.5662.53\n");

        assertEquals(expectedEmailBody.toString(),actualEmailBody.toString());
    }
}