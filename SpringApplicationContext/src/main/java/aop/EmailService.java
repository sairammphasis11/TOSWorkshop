package aop;

public class EmailService implements MessagingService {


    EmailService(){
        System.out.println("EmailService Bean is Created");
    }
    @Override
    public boolean readMessage(String msg) {
        System.out.println("Email service "+msg);
       Integer.parseInt("n88");
        return true;
    }
}
