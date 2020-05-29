package org.myspring.beans.factory;

import org.junit.Assert;
import org.junit.Test;
import org.myspring.beans.definition.ClassBeanDefinition;

public class DefaultBeanFactoryTest {

    @Test
    public void instantiateTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        beanFactory.registerBeanDefinition(new ClassBeanDefinition(TestClass.class));
        beanFactory.instantiate();

        TestClass testClass = beanFactory.getBean(TestClass.class);

        Assert.assertEquals(testClass.getMessage(), "helloWorld");
    }

    @Test
    public void instantiateWithDependencyInjectionTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        beanFactory.registerBeanDefinition(new ClassBeanDefinition(TestClass.class));
        beanFactory.registerBeanDefinition(new ClassBeanDefinition(TestClass2.class));
        beanFactory.instantiate();

        TestClass testClass = beanFactory.getBean(TestClass.class);
        TestClass2 testClass2 = beanFactory.getBean(TestClass2.class);

        Assert.assertEquals(testClass.getMessage(), "helloWorld");
        Assert.assertEquals(testClass2.getMessage(), "helloWorld");
    }


    public static class TestClass {
        private String message = "helloWorld";

        public String getMessage() {
            return message;
        }
    }

    public static class TestClass2 {
        private final TestClass testClass;

        public TestClass2(TestClass testClass) {
            this.testClass = testClass;
        }

        public String getMessage() {
            return testClass.getMessage();
        }
    }
}
