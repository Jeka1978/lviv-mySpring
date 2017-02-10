package reflection;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class ProstoTak {
    public void doX(){
        System.out.println("XXXXX");
    }
    public void doY(){
        System.out.println("YYYYYYYy");
    }

    @Run
    public void abc() {
        System.out.println("Started");
    }
}
