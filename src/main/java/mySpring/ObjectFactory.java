package mySpring;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
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
    @Getter
    private Map<Class, Object> singeltons = new HashMap<>();

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
        type = resolveImpl(type);

        T t = BeforeInitializationConfigurer.configureBeforeInit(type);

        configure(t);

        invokeInitMethods(type, t);

        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> {

                        System.out.println("************BENCHMARK*********");
                        System.out.println(method.getName() + " was started");

                        Object retVal = method.invoke(t, args); // why t here must be final ???

                        System.out.println(method.getName() + " was finished");
                        System.out.println("************BENCHMARK   END*********");
                        return retVal;
                    }

            );
        }

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
