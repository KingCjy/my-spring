package org.myspring.beans.definition;

import org.myspring.beans.annotations.Component;
import org.myspring.beans.utils.MyReflectionUtils;

import java.util.Set;

public class ClassBeanDefinitionScanner {

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    public ClassBeanDefinitionScanner(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void scan(String basePackage) {
        Set<Class> findClasses = MyReflectionUtils.findAnnotatedClasses(basePackage, Component.class);

        findClasses.forEach(targetClass -> beanDefinitionRegistry.registerBeanDefinition(new ClassBeanDefinition(targetClass)));
    }
}
