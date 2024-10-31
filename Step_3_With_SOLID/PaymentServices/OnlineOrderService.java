package PaymentServices;

import NotificationServices.OrderNotifier;

public class OnlineOrderService implements OrderService {
    private final OrderNotifier notifier;

    public OnlineOrderService(OrderNotifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void onSiteOrderRegister(String customerName) {
        // Empty Body
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        System.out.println("online order registered for " + customerName);
        notifier.notify("Order registered for " + customerName);
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        // Empty Body
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
        notifier.notify("Payment completed for " + foodPrice + " Tomans!");
    }
}