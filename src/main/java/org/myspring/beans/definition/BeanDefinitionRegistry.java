package org.myspring.beans.definition;

import java.util.Set;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(BeanDefinition beanDefinition);
    Set<BeanDefinition> getBeanDefinitions();
    BeanDefinition getBeanDefinition(Class<?> targetClass);
}
