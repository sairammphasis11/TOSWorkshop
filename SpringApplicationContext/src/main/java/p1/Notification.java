package p1;

public class Notification implements MessagingService{
    @Override
    public void readMessage(String msg) {
        System.out.println("Notification "+msg);
    }
}
