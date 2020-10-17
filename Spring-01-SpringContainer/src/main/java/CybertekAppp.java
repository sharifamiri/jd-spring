import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.FullTimeMentor;

public class CybertekAppp {
    public static void main(String[] args) {

        //1st Way
        //BeanFactory container = new ClassPathXmlApplicationContext("config.xml");

        //2nd Way;
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");


        //Mentor mentor = new FullTimeMentor();
        //Mentor mentor = (Mentor)container.getBean("partTimeMentor");

        Mentor mentor = container.getBean("fullTimeMentor",Mentor.class);

        mentor.createAccount();
    }
}
