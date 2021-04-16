package autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/autowiring/Beans.xml");

        Thread.sleep(4000);

        TextEditor editor= (TextEditor) context.getBean("TextEditor");
        editor.checkSpell();
        editor.destroy();

    }
}
