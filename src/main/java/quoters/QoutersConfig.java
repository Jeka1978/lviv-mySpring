package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudnitskih on 3/6/17.
 */
@Configuration
public class QoutersConfig {
    @Bean(name = "ShakespearQuoter")
    public ShakespearQuoter shakespearQuoter() {
        ShakespearQuoter shakespeareQuoter = new ShakespearQuoter();

        shakespeareQuoter.setMessage("2 b || ! 2 b");

        return shakespeareQuoter;
    }

    @Bean(name = "TerminatorQuoter")
    public TerminatorQuoter terminatorQuoter() {
        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();

        List<String> terminatorQuotes = new ArrayList<>();

        terminatorQuotes.add("I'll be back");
        terminatorQuotes.add("Astalavista baby");

        terminatorQuoter.setMessages(terminatorQuotes);

        return terminatorQuoter;
    }

    @Bean(initMethod = "talk")
    public TalkingRobotImpl talkingRobotImpl() {
        TalkingRobotImpl talkingRobotImpl = new TalkingRobotImpl();

        List<Quoter> quoterList = new ArrayList<>();

        quoterList.add(shakespearQuoter());
        quoterList.add(terminatorQuoter());

        talkingRobotImpl.setQuoters(quoterList);

        return talkingRobotImpl;
    }

}
