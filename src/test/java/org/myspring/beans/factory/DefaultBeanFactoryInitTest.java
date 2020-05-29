package org.myspring.beans.factory;

import org.junit.Assert;
import org.junit.Test;
import org.myspring.beans.annotations.Component;
import org.myspring.beans.definition.ClassBeanDefinitionScanner;

@Component
public class DefaultBeanFactoryInitTest {

    private String message = "helloWorld";

    @Test
    public void initializeTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        ClassBeanDefinitionScanner classBeanDefinitionScanner = new ClassBeanDefinitionScanner(beanFactory);
        classBeanDefinitionScanner.scan("org.myspring.beans");

        beanFactory.instantiate();

        DefaultBeanFactoryInitTest beanFactoryInitTest = beanFactory.getBean(DefaultBeanFactoryInitTest.class);

        Assert.assertEquals(beanFactoryInitTest.getMessage(), message);
    }

    public String getMessage() {
        return message;
    }
}
