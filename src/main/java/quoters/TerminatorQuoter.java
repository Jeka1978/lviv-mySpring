package quoters;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 11/02/2017.
 */
@Setter
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    public TerminatorQuoter() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public List<String> getMessages() {
        return this.messages;
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
