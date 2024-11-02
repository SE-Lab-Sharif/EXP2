package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;

public class EmailMessageService implements EmailServiceInterface {
    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        System.out.println("Sending email message to: " + emailMessage.getTargetEmailAddress());
        System.out.println("Message content: " + emailMessage.getContent());
    }
}
