package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.ErrorData;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class EmailBodyCreatorTest {

    @Test
    public void should_return_email_body()
    {
        ArrayList<ErrorData> errorList=new ArrayList<>();
        ErrorData errorData=new ErrorData();
        errorData.setDateTime("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
        errorData.setId("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
        errorData.setTitleDescription("2020-01-25 16:16:51,484 [15422630]  ERROR - j.psi.stubs.StubTreeLoaderImpl - Last Action: Run ");
        errorList.add(errorData);

        EmailBodyCreator emailBodyCreator=new EmailBodyCreator();
        StringBuilder actualEmailBody=emailBodyCreator.createMailBody(errorList);

        StringBuilder expectedEmailBody = new StringBuilder("We have notified that there are 1 errors. More Details below, \n\n2020-01-25 16:16:51 - j.psi.stubs.StubTreeLoaderImpl  - Last Action: Run\n");

        assertEquals(expectedEmailBody.toString(),actualEmailBody.toString());
    }
}