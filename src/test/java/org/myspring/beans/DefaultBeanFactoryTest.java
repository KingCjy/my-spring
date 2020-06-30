package org.myspring.beans;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBeanFactoryTest {

    @Test
    public void instantiateTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        beanFactory.registerBeanDefinition(new ClassBeanDefinition(TestClass.class));
        beanFactory.instantiate();

        TestClass testClass = beanFactory.getBean(TestClass.class);

        assertThat(testClass.getMessage()).isEqualTo("helloWorld");
    }

    @Test
    public void instantiateWithDependencyInjectionTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        beanFactory.registerBeanDefinition(new ClassBeanDefinition(TestClass.class));
        beanFactory.registerBeanDefinition(new ClassBeanDefinition(TestClass2.class));
        beanFactory.instantiate();

        TestClass testClass = beanFactory.getBean(TestClass.class);
        TestClass2 testClass2 = beanFactory.getBean(TestClass2.class);

        assertThat(testClass.getMessage()).isEqualTo("helloWorld");
        assertThat(testClass2.getMessage()).isEqualTo("helloWorld");
    }


    static class TestClass {
        private String message = "helloWorld";

        public String getMessage() {
            return message;
        }
    }

    static class TestClass2 {
        private final TestClass testClass;

        public TestClass2(TestClass testClass) {
            this.testClass = testClass;
        }

        public String getMessage() {
            return testClass.getMessage();
        }
    }
}