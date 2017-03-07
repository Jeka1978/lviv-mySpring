package mySpring;

import com.sun.scenario.effect.Reflection;
import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Evegeny on 10/02/2017.
 */
@Setter
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private final HashMap<Class, Object> singletonesMap;
    private Config config = new JavaConfig();
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();
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

        // create singletons from config
        List<Class> singletons = config.getSingletons();
        singletonesMap = new HashMap<Class, Object>();
        for(Class aClass: singletons) {
            Object impl = createObject(aClass);
            singletonesMap.put(aClass, impl);
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        if(singletonesMap.containsKey(type)) {
            return (T)singletonesMap.get(type);
        }

        type = resolveImpl(type);

        Singleton singleton = type.getAnnotation(Singleton.class);
        if(singleton != null) {
            lock.lock();
        }

        T t = type.newInstance();

        configure(t);

        invokeInitMethods(type, t);

        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> {

                        System.out.println("************BENCHMARK*********");
                        System.out.println(method.getName() + " was started");

                        Object retVal = method.invoke(t, args);

                        System.out.println(method.getName() + " was finished");
                        System.out.println("************BENCHMARK   END*********");
                        return retVal;

                    }

            );
        }

        if(singleton != null) {
            singletonesMap.put(type, t);
            lock.unlock();
        }

        // check whether a type is singleton
        return t;
    }

    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t));
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        return type;
    }
}
