package edu.sharif.selab.services;

import edu.sharif.selab.models.SmsMessage;

public class SmsMessageService implements SmsServiceInterface {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        System.out.println("Sending SMS message to: " + smsMessage.getTargetPhoneNumber());
        System.out.println("Message content: " + smsMessage.getContent());
    }
}
