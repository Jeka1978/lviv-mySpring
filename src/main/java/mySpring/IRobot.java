package mySpring;

import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finised my work");

    }
}
