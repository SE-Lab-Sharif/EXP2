package PaymentServices;
import MessagingServices.MessagingService;

public class OnlineOrderService implements OrderService {
    private MessagingService messagingService;

    public OnlineOrderService(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @Override
    public void onSiteOrderRegister(String customerName) {
        //Empty Body!
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        System.out.println("online order registered for " + customerName);
        messagingService.sendMessage("Order registered for " + customerName);
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        //Empty Body
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
        messagingService.sendMessage("Payment completed for " + foodPrice + " Tomans!");
    }
}
