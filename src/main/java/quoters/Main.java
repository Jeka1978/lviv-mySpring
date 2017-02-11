package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Evegeny on 11/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(TalkingRobot.class);
        context.getBean(TalkingRobot.class);
        context.getBean(TalkingRobot.class);
    }
}
