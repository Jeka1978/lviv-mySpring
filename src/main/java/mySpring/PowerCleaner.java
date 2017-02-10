package mySpring;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class PowerCleaner implements Cleaner {
    @InjectRandomInt(min = 3,max = 8)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVvvvvvvvvvvvvv");
        }
    }
}
