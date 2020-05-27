package org.myspring.beans.factory;

public interface BeanFactory {
    Object getBean(String name);
    <T> T getBean(Class<T> type);
    <T> T getBean(String name, Class<T> type);
    Object[] getBeans();
}
