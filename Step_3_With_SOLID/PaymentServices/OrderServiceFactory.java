
package PaymentServices;

import MessagingServices.MessagingService;
import NotificationServices.OrderNotifier;

public class OrderServiceFactory {

    public static OrderService createOrderService(String type, MessagingService messagingService) {
        OrderNotifier notifier = new OrderNotifier(messagingService);

        if ("online".equalsIgnoreCase(type)) {
            return new OnlineOrderService(notifier);
        } else if ("onsite".equalsIgnoreCase(type)) {
            return new OnSiteOrderService(notifier);
        }
        throw new IllegalArgumentException("Unknown order type: " + type);
    }
}