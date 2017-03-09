package mySpring;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ObjectFactory factory = ObjectFactory.getInstance();
        IRobot iRobot = factory.createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
