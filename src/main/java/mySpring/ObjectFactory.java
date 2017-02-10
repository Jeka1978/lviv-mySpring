package mySpring;

import com.sun.scenario.effect.Reflection;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private Reflections scanner = new Reflections("mySpring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            objectConfigurers.add(aClass.newInstance());
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        T t = type.newInstance();
       objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t));


        return t;
    }
}
