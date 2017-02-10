package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class InjectByTypeObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = ObjectFactory.getInstance().createObject(field.getType());

                field.set(t,object);

            }
        }
    }
}
