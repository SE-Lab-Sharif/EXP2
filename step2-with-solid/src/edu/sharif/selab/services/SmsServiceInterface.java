package edu.sharif.selab.services;

import edu.sharif.selab.models.SmsMessage;

public interface SmsServiceInterface {
    void sendSmsMessage(SmsMessage smsMessage);
}