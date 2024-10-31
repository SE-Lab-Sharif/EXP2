package PaymentServices;

import MessagingServices.MessagingService;

public class OnSiteOrderService implements OrderService {
    private MessagingService messagingService;

    public OnSiteOrderService(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @Override
    public void onSiteOrderRegister(String customerName) {
        System.out.println("on-Site order registered for " + customerName);
        messagingService.sendMessage("On-site order registered for " + customerName);
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        //Empty Body
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        System.out.println("on-Site Payment with Price : " + foodPrice + " Tomans!");
        messagingService.sendMessage("On-site payment completed for " + foodPrice + " Tomans!");
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        //Empty Body
    }
}
