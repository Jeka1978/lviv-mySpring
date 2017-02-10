package mySpring;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class ConsoleSpeaker implements Speaker {

    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
