package quoters;

import lombok.Setter;

/**
 * Created by Evegeny on 11/02/2017.
 */
@Setter
public class ShakespearQuoter implements Quoter {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
