package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;

public interface EmailServiceInterface {
    void sendEmailMessage(EmailMessage emailMessage);
}
