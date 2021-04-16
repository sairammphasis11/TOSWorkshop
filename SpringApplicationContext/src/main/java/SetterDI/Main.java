package SetterDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/SetterDI/Beans.xml");

        Thread.sleep(2000);

        TextEditor editor= (TextEditor) context.getBean("TextEditor");
        editor.checkSpell();

    }
}
