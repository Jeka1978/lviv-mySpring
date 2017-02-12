package mySpring;

import tdd.PDVResolver;
import tdd.PDVResolverImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class JavaConfig implements Config {
    private Map<Class, Class> ifc2Impl = new HashMap<>();

    public JavaConfig() {
        ifc2Impl.put(Speaker.class, ConsoleSpeaker.class);
        ifc2Impl.put(Cleaner.class, PowerCleaner.class);
        ifc2Impl.put(PDVResolver.class, PDVResolverImpl.class);
    }

    public void bind(Class ifc, Class impl) {
        ifc2Impl.put(ifc, impl);
    }

    @Override
    public <T> Class<T> getImpl(Class<T> type) {
        return ifc2Impl.get(type);
    }
}
