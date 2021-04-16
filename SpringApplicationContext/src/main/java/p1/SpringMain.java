package p1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/p1/Beans.xml");

        Thread.sleep(5000);

        MessagingService messagingService= (MessagingService) context.getBean("EmailBean");
        messagingService.readMessage("EmailServiceBean is called");
        messagingService= (MessagingService) context.getBean("NotificationBean");
        messagingService.readMessage("Notificcation is invoked");
    }
}
