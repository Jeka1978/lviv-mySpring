package quoters;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 11/02/2017.
 */
@Setter
public class TalkingRobotImpl implements TalkingRobot {

    private List<Quoter> quoters;

    public TalkingRobotImpl() {
        this.quoters = new ArrayList<Quoter>();
    }

    public void addQuoter(Quoter quoter) {
        quoters.add(quoter);
    }

    public List<Quoter> getQuoters() {
        return quoters;
    }

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
