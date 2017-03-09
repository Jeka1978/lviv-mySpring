package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andriy Tykhonov on 3/9/17.
 */
@Configuration
public class ApplicationConfig {

    @Bean(initMethod = "talk")
    public TalkingRobot talkingRobot() {
        TalkingRobotImpl talkingRobot = new TalkingRobotImpl();
        talkingRobot.addQuoter(shakespearQuoter());
        talkingRobot.addQuoter(terminatorQuoter());
        return talkingRobot;
    }

    @Bean
    public ShakespearQuoter shakespearQuoter() {
        ShakespearQuoter quoter = new ShakespearQuoter();
        quoter.setMessage("2 b || ! 2 b");
        return quoter;
    }

    @Bean
    public TerminatorQuoter terminatorQuoter() {
        TerminatorQuoter quoter = new TerminatorQuoter();
        quoter.addMessage("I'll be back");
        quoter.addMessage("Astalavista baby");
        return quoter;
    }
}
