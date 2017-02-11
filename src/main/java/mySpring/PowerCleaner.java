package mySpring;

/**
 * Created by Evegeny on 10/02/2017.
 */
@Benchmark
public class PowerCleaner implements Cleaner {
    @InjectRandomInt(min = 3,max = 8)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVvvvvvvvvvvvvv");
        }

        doX();

    }

    public void doX(){
        System.out.println("XXXXXXXXXXXXXx");
    }
}
