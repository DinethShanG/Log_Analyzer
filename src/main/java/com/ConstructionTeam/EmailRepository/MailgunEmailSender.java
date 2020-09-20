package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.User;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.util.Collections;

public class MailgunEmailSender implements EmailSender  {
    private static final String API_KEY = "";
    private static final String YOUR_DOMAIN_NAME = "";

    public void sendSimpleMessage(User user, StringBuilder emailBody) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post(YOUR_DOMAIN_NAME + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "Log Analyze Notification <loganalyzenotifier@gmail.com>")
                .field("to", user.getEmail())
                .field("subject", "Hello "+ user.getName())
                .field("text", Collections.singleton(emailBody))
                .asJson();

        new EmailSenderValidation().validateEmail(request,user);

    }
}
