package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

public interface TelegramServiceInterface {
    void sendTelegramMessage(TelegramMessage telegramMessage);
}
