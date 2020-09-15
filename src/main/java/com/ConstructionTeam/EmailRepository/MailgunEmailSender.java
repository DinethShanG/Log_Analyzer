package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.User;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.util.Collections;

public class MailgunEmailSender {
    private static final String API_KEY = "f2d305922076da912e519c023b6290ce-d5e69b0b-2f97f4f7";
    private static final String YOUR_DOMAIN_NAME = "https://api.mailgun.net/v3/sandbox9d1f84352136426db7937366d3260127.mailgun.org";


    public void sendSimpleMessage(User user, StringBuilder emailBody) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post(YOUR_DOMAIN_NAME + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "Log Analyze Notification <loganalyzenotifier@gmail.com>")
                .field("to", user.getEmail())
                .field("subject", "Hello "+ user.getName())
                .field("text", Collections.singleton(emailBody))
                .asJson();
        System.out.println(request.getBody());
    }
}
