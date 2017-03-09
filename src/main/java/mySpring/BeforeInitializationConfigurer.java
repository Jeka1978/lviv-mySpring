package mySpring;

public class BeforeInitializationConfigurer {
    public static <T> T configureBeforeInit(Class type) throws IllegalAccessException, InstantiationException {
        if(type.isAnnotationPresent(Singleton.class)) {
            if (ObjectFactory.getInstance().getSingeltons().get(type) == null) {
                ObjectFactory.getInstance().getSingeltons().put(type, type.newInstance());
                return (T) ObjectFactory.getInstance().getSingeltons().get(type);
            } else {
                return (T) ObjectFactory.getInstance().getSingeltons().get(type);
            }
        }
        return (T) type.newInstance();
    }

}
