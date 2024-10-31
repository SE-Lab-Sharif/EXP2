import PaymentServices.OrderService;
import PaymentServices.OrderServiceFactory;
import MessagingServices.TelegramService;
import MessagingServices.MessagingService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessagingService messagingService = new TelegramService();
        String customerName;
        Order order;
        int customerAnswerForOrder = 0;
        int customerAnswerForPaymentMethod = 0;

        System.out.println("Enter Customer Name : ");
        customerName = scanner.nextLine();
        order = new Order(customerName);

        while (customerAnswerForOrder != 3) {
            System.out.println("For Ordering Sandwich enter 1.");
            System.out.println("For Ordering Pizza enter 2.");
            System.out.println("For submit your order enter 3");
            customerAnswerForOrder = scanner.nextInt();

            if (customerAnswerForOrder == 1) {
                order.addItem(new Food("sandwich", 1000));
            } else if (customerAnswerForOrder == 2) {
                order.addItem(new Food("pizza", 2000));
            }
        }

        System.out.println("Enter Your Payment Method (1 for online and 2 for on-site):");
        customerAnswerForPaymentMethod = scanner.nextInt();
        OrderService orderService = null;

        if (customerAnswerForPaymentMethod == 1) {
            orderService = OrderServiceFactory.createOrderService("online", messagingService);
            orderService.onlineOrderRegister(customerName);
        } else if (customerAnswerForPaymentMethod == 2) {
            orderService = OrderServiceFactory.createOrderService("onsite", messagingService);
            orderService.onSiteOrderRegister(customerName);
        }

        System.out.println("Pay Price:");
        if (orderService != null) {
            if (orderService instanceof OnlineOrderService) {
                orderService.onlineOrderPayment(order.getTotalPrice());
            } else if (orderService instanceof OnSiteOrderService) {
                orderService.onSiteOrderPayment(order.getTotalPrice());
            }
        }
        System.out.println(order);
    }
}