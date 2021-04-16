package assesment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/assesment/Beans.xml");

        Profile profile = (Profile) context.getBean("profile");
        profile.printAge();
        profile.printName();
    }
}