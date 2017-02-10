package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class InjectRandomIntObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(t,value);

            }
        }
    }
}
