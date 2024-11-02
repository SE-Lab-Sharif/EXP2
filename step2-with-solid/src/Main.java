import edu.sharif.selab.factory.MessageFactory;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.services.EmailMessageService;
import edu.sharif.selab.services.SmsMessageService;
import edu.sharif.selab.services.TelegramMessageService;
import edu.sharif.selab.services.EmailServiceInterface;
import edu.sharif.selab.services.SmsServiceInterface;
import edu.sharif.selab.services.TelegramServiceInterface;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer = 0;

        do {
            Message message = null;
            String messageType;
            String source;
            String target;
            String content;

            System.out.println("Enter message type (sms/email/telegram): ");
            messageType = scanner.next();

            message = MessageFactory.createMessage(messageType);

            if (message instanceof SmsMessage) {
                SmsServiceInterface smsService = new SmsMessageService();
                System.out.print("Enter source phone: ");
                source = scanner.next();
                System.out.print("Enter target phone: ");
                target = scanner.next();
                System.out.println("Write your message: ");
                content = scanner.next(".*$");
                ((SmsMessage) message).setSourcePhoneNumber(source);
                ((SmsMessage) message).setTargetPhoneNumber(target);
                message.setContent(content);
                smsService.sendSmsMessage((SmsMessage) message);

            } else if (message instanceof EmailMessage) {
                EmailServiceInterface emailService = new EmailMessageService();
                System.out.print("Enter source email: ");
                source = scanner.next();
                System.out.print("Enter target email: ");
                target = scanner.next();
                System.out.println("Write your message: ");
                content = scanner.next();
                ((EmailMessage) message).setSourceEmailAddress(source);
                ((EmailMessage) message).setTargetEmailAddress(target);
                message.setContent(content);
                emailService.sendEmailMessage((EmailMessage) message);

            } else if (message instanceof TelegramMessage) {
                TelegramServiceInterface telegramService = new TelegramMessageService();
                System.out.print("Enter chat ID: ");
                target = scanner.next();
                System.out.println("Write your message: ");
                content = scanner.next();
                ((TelegramMessage) message).setChatId(target);
                message.setContent(content);
                telegramService.sendTelegramMessage((TelegramMessage) message);
            }
        } while (true);
    }
}
