package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * Created by Anatoliy on 07.03.2017.
 */
@Configuration
public class QuotersConfig {

    @Bean
    public ShakespearQuoter shakespearQuoter(){
        ShakespearQuoter quoter = new ShakespearQuoter();
        quoter.setMessage("2 b || ! 2 b");
        return quoter;
    }

    @Bean
    public TerminatorQuoter terminatorQuoter(){
        TerminatorQuoter quoter = new TerminatorQuoter();
        ArrayList<String> messages = new ArrayList<String>();
        messages.add("I'll be back");
        messages.add("Astalavista baby");
        quoter.setMessages(messages);
        return quoter;
    }

    @Bean
    public TalkingRobotImpl robot(){
        TalkingRobotImpl r = new TalkingRobotImpl();
        ArrayList<Quoter> quoters = new ArrayList<Quoter>();
        quoters.add(shakespearQuoter());
        quoters.add(terminatorQuoter());
        r.setQuoters(quoters);
        r.talk();
        return r;
    }
}
