package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class ReflectionService {
    public void printApi(Object o) throws Exception {
        Class<?> type = o.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(o);
            }
        }
    }


}
