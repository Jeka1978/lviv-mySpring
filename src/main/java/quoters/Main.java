package quoters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 11/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(QoutersConfig.class);
        context.getBean(TalkingRobot.class);
        context.getBean(TalkingRobot.class);
        context.getBean(TalkingRobot.class);
    }
}
