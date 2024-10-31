package NotificationServices;

import MessagingServices.MessagingService;

public class OrderNotifier {
    private final MessagingService messagingService;

    public OrderNotifier(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    public void notify(String message) {
        messagingService.sendMessage(message);
    }
}