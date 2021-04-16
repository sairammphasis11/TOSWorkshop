package p1;

public class EmailService implements  MessagingService {


    EmailService(){
        System.out.println("EmailService Bean is Created");
    }
    @Override
    public void readMessage(String msg) {
        System.out.println("Email service "+msg);
    }
}
