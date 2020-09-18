package com.ConstructionTeam.EmailRepository;

import com.ConstructionTeam.DataModels.User;


public interface EmailSender {
    public void sendSimpleMessage(User user, StringBuilder emailBody);

}
