package reflection;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ReflectionService reflectionService = new ReflectionService();
        ProstoTak prostoTak = new ProstoTak();
        reflectionService.printApi(prostoTak);
    }
}
