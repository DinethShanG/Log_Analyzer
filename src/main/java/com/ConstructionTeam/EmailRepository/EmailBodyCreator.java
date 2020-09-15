package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.ErrorData;

import java.util.ArrayList;

public class EmailBodyCreator {
    public StringBuilder createMailBody(ArrayList<ErrorData> errorList){
        StringBuilder emailBody = new StringBuilder("We have notified that there are "+errorList.size()+" errors. More Details below, \n\n");
        for (ErrorData errorData:errorList) {
            emailBody.append(errorData.getDateTime()+" - "+errorData.getTitle()+" - "+errorData.getDescription()+"\n");
        }
        return emailBody;
    }
}
