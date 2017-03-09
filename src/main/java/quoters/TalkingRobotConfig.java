package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TalkingRobotConfig {

    @Bean
    public TalkingRobotImpl talkingRobotImpl() {
        TalkingRobotImpl talkingRobotImpl = new TalkingRobotImpl();
        talkingRobotImpl.setQuoters(Arrays.asList(shakespearQuoter(), terminatorQuoter()));

        return talkingRobotImpl;
    }

    @Bean
    public ShakespearQuoter shakespearQuoter() {
        ShakespearQuoter shakespearQuoter = new ShakespearQuoter();
        shakespearQuoter.setMessage("2 b || !2 b");
        return shakespearQuoter;
    }
    @Bean
    public TerminatorQuoter terminatorQuoter() {
        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();
        terminatorQuoter.setMessages(Arrays.asList("I'll be back", "I need your clothes, your boots and motocycle"));

        return terminatorQuoter;
    }
}
