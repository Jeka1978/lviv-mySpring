package quoters;

import lombok.Setter;

import java.util.List;

/**
 * Created by Evegeny on 11/02/2017.
 */
@Setter
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
