package edu.sharif.selab.factory;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

public class MessageFactory {
    public static Message createMessage(String type) {
        switch (type.toLowerCase()) {
            case "sms":
                return new SmsMessage();
            case "email":
                return new EmailMessage();
            case "telegram":
                return new TelegramMessage();
            default:
                throw new IllegalArgumentException("Invalid message type: " + type);
        }
    }
}
