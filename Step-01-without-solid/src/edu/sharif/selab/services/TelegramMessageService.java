package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService {
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        System.out.println("Sending Telegram message to chat ID: " + telegramMessage.getChatId());
        System.out.println("Message content: " + telegramMessage.getContent());
    }

    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body
    }
}
