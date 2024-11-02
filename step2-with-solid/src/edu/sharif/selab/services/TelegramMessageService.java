package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements TelegramServiceInterface {
    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        System.out.println("Sending Telegram message to chat ID: " + telegramMessage.getChatId());
        System.out.println("Message content: " + telegramMessage.getContent());
    }
}
