package org.myspring.beans;

import java.lang.reflect.Constructor;
import java.util.*;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private Set<BeanDefinition> beanDefinitions = new HashSet<>();
    private Map<String, Object> beans = new HashMap<>();

    public void instantiate() {
        beanDefinitions.forEach(beanDefinition -> instantiateBeanDefinition(beanDefinition));
    }

    private void instantiateBeanDefinition(BeanDefinition beanDefinition) {
        if(beans.get(beanDefinition.getName()) != null) {
            return;
        }

        Constructor cosntructor = beanDefinition.getType().getDeclaredConstructors()[0];
        Object[] parameters = getParameters(cosntructor.getParameterTypes());

        Object instance = BeanUtils.instantiateClass(cosntructor, parameters);
        beans.put(beanDefinition.getName(), instance);
    }

    private Object[] getParameters(Class<?>[] parameterTypes) {
        List<Object> instances = new ArrayList<>();
        for (Class<?> typeParameter : parameterTypes) {
            Object instance = getInstanceBean(typeParameter);
            instances.add(instance);
        }

        return instances.toArray();
    }

    private Object getInstanceBean(Class<?> typeParameter) {
        if(beans.get(typeParameter) == null) {
            instantiateBeanDefinition(getBeanDefinition(typeParameter));
        }

        return beans.get(typeParameter.getName());
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
    }

    @Override
    public Set<BeanDefinition> getBeanDefinitions() {
        return beanDefinitions;
    }

    @Override
    public BeanDefinition getBeanDefinition(Class<?> targetClass) {
        return this.beanDefinitions.stream()
                .filter(beanDefinition -> beanDefinition.getType().equals(targetClass))
                .findAny()
                .orElseGet(null);
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }

    @Override
    public <T> T getBean(Class<T> type) {
        return (T) beans.get(type.getName());
    }

    @Override
    public <T> T getBean(String name, Class<T> type) {
        return (T) beans.get(name);
    }

    @Override
    public Object[] getBeans() {
        return beans.values().toArray(new Object[] {});
    }
}
