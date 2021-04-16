package p2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import p1.MessagingService;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/p2/Beans.xml");

        Thread.sleep(5000);

        TextEditor editor= (TextEditor) context.getBean("TextEditor");
        editor.checkSpell();

    }
}
