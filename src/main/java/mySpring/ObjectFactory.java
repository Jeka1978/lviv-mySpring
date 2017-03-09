package mySpring;

import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by Evegeny on 10/02/2017.
 */
@Setter
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private Reflections scanner = new Reflections("mySpring");
    private Map<Class, Object> instances;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            objectConfigurers.add(aClass.newInstance());
        }
        instances = new HashMap<Class, Object>();
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        type = resolveImpl(type);
        
        T instance = (T) instances.get(type);
        if (instance == null) {
            instance = type.newInstance();
            if (type.isAnnotationPresent(Singleton.class)) {
                instances.put(type, instance);
            }
        }

        configure(instance);

        invokeInitMethods(type, instance);

        if (type.isAnnotationPresent(Benchmark.class)) {
            T finalInstance = instance;
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> {

                        System.out.println("************BENCHMARK*********");
                        System.out.println(method.getName() + " was started");

                        Object retVal = method.invoke(finalInstance, args);

                        System.out.println(method.getName() + " was finished");
                        System.out.println("************BENCHMARK   END*********");
                        return retVal;

                    }

            );
        }

        return instance;
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
