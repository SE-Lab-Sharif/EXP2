package PaymentServices;

import NotificationServices.OrderNotifier;

public class OnSiteOrderService implements OrderService {
    private final OrderNotifier notifier;

    public OnSiteOrderService(OrderNotifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void onSiteOrderRegister(String customerName) {
        System.out.println("on-Site order registered for " + customerName);
        notifier.notify("On-site order registered for " + customerName);
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        // Empty Body
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        System.out.println("on-Site Payment with Price : " + foodPrice + " Tomans!");
        notifier.notify("On-site payment completed for " + foodPrice + " Tomans!");
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        // Empty Body
    }
}