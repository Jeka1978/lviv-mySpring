package quoters;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 11/02/2017.
 */
@Setter
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
