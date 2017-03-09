package quoters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.provider.SHA;

/**
 * Created by Evegeny on 11/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TalkingRobotConfig.class);

        TalkingRobot robot = context.getBean(TalkingRobot.class);
        robot.talk();

    }
}
