package com.ConstructionTeam;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;

public class EmailSender {
//
//    public static void main(String[] args) throws Exception {
//        EmailSender emailSender = new EmailSender();
//        emailSender.Send();
//    }

    public static void main(String args[]) throws Exception {

        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("chinthy97@gmail.com"));

        InternetAddress[] addrs = InternetAddress.parse("kgcchathuranga97@gmail.com", false);
        msg.setRecipients(Message.RecipientType.TO, addrs);

        msg.setSubject("Hello How are you ");
        msg.setText("this from mail gun");
        msg.setSentDate(new Date());

        SMTPTransport t =
                (SMTPTransport) session.getTransport("smtps");
        t.connect("smtp.mailgun.org", "postmaster@sandboxf8c8bcefed734b29b97f81c9e1d60f6b.mailgun.org", "b102bd203f1fbb5a5cf6981572e0e86e-0f472795-64ab601b");
        t.sendMessage(msg, msg.getAllRecipients());

        System.out.println("Response: " + t.getLastServerResponse());

        t.close();
    }
}
