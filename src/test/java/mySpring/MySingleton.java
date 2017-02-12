package mySpring;

/**
 * Created by Evegeny on 12/02/2017.
 */
@Singleton
public class MySingleton {
    static int counter;
    public MySingleton() {
        counter++;
    }
}
