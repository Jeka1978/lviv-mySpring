package mySpring;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 12/02/2017.
 */
public class ObjectFactoryTest {
    @Test
    public void testThanSingletonIsSingleton() throws Exception {
        ObjectFactory factory = ObjectFactory.getInstance();
        factory.createObject(MySingleton.class);
        factory.createObject(MySingleton.class);
        factory.createObject(MySingleton.class);
        factory.createObject(MySingleton.class);

        Assert.assertEquals(1,MySingleton.counter);
    }

}