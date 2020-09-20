package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.User;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

public class EmailSenderValidation {
    public void validateEmail(HttpResponse<JsonNode> request, User user){

        if (request.isSuccess()){
            System.out.println("Successfully! send an Error Report to "+user.getName()+" via mail: "+user.getEmail());
        }
        else{
            System.out.println("Failed to send an Error Report to "+user.getName()+" via mail: "+user.getEmail()+ " because of "+ request.getBody().toPrettyString());
        }
    }
}
