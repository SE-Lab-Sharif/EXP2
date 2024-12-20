package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

public interface MessageService {
    void sendSmsMessage(SmsMessage smsMessage);

    void sendEmailMessage(EmailMessage emailMessage);

    void sendTelegramMessage(TelegramMessage telegramMessage);
}
