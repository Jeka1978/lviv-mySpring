package tdd;

/**
 * Created by Evegeny on 11/02/2017.
 */
public class PDVResolverSingleton {
    private static PDVResolverSingleton ourInstance = new PDVResolverSingleton();

    public static PDVResolverSingleton getInstance() {
        return ourInstance;
    }

    private PDVResolverSingleton() {
    }

    public double getPDV(){
        return 10;
    }
}
