package aop;

public class Notification implements MessagingService {
    @Override
    public boolean readMessage(String msg) {
        System.out.println("Notification "+msg);
        return true;
    }
}
