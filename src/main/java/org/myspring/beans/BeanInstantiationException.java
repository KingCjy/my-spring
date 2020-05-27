package org.myspring.beans;

import java.lang.reflect.Constructor;

public class BeanInstantiationException extends RuntimeException {

    private final Class<?> beanClass;

    public BeanInstantiationException(Class<?> beanClass, String message) {
        super(message);
        this.beanClass = beanClass;
    }

    public BeanInstantiationException(Class<?> beanClass, String message, Throwable cause) {
        super(message, cause);
        this.beanClass = beanClass;
    }

    public BeanInstantiationException(Constructor<?> constructor, String message, Throwable cause) {
        super(message, cause);
        this.beanClass = constructor.getDeclaringClass();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }
}
