package org.myspring.beans.definition;

import org.junit.Assert;
import org.junit.Test;
import org.myspring.beans.annotations.Component;
import org.myspring.beans.factory.DefaultBeanFactory;

@Component
public class ClassBeanDefinitionScannerTest {

    @Test
    public void scanAndRegisterBeanDefinitionTest() {
        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultBeanFactory();

        ClassBeanDefinitionScanner classBeanDefinitionScanner = new ClassBeanDefinitionScanner(beanDefinitionRegistry);
        classBeanDefinitionScanner.scan(ClassBeanDefinitionScannerTest.class.getPackageName());

        Assert.assertNotNull(beanDefinitionRegistry.getBeanDefinition(ClassBeanDefinitionScannerTest.class));
    }
}
