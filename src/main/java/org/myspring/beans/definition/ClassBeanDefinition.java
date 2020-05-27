package org.myspring.beans.definition;

public class ClassBeanDefinition implements BeanDefinition {

    private String name;
    private Class<?> type;

    public ClassBeanDefinition(Class<?> type) {
        this(type.getName(), type);
    }

    public ClassBeanDefinition(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
