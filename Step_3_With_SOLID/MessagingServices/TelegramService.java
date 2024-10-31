package MessagingServices;

public class TelegramService implements MessagingService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message to Telegram: " + message);
    }
}
