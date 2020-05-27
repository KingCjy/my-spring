package org.myspring.beans;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BeanUtils {

    public static <T> T instantiateClass(Class<T> targetClass) {
        if(targetClass.isInterface()) {
            throw new BeanInstantiationException(targetClass, "Specified class is an interface");
        }

        try {
            return instantiateClass(targetClass.getConstructor());
        } catch (NoSuchMethodException e) {
            throw new BeanInstantiationException(targetClass, "No default constructor found", e);
        }
    }

    public static <T> T instantiateClass(Constructor<T> constructor, Object... args) {
        try {
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            if(args.length != parameterTypes.length) {
                throw new IllegalArgumentException("argument length and parameter length is not match");
            }
            return constructor.newInstance(args);
        } catch (InstantiationException ex) {
            throw new BeanInstantiationException(constructor, "Is it an abstract class?", ex);
        } catch (IllegalAccessException ex) {
            throw new BeanInstantiationException(constructor, "Is the constructor accessible?", ex);
        } catch (IllegalArgumentException ex) {
            throw new BeanInstantiationException(constructor, "Illegal arguments for constructor", ex);
        } catch (InvocationTargetException ex) {
            throw new BeanInstantiationException(constructor, "Constructor threw exception", ex.getTargetException());
        }
    }
}
