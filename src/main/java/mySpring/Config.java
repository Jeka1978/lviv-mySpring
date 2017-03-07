package mySpring;

import java.util.List;

/**
 * Created by Evegeny on 10/02/2017.
 */
public interface Config {
    <T> Class<T> getImpl(Class<T> type);
    List<Class> getSingletons();
}
