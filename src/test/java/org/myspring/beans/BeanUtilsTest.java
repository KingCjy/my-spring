package org.myspring.beans;

import org.junit.Assert;
import org.junit.Test;
import org.myspring.beans.BeanInstantiationException;
import org.myspring.beans.BeanUtils;

import java.util.List;

public class BeanUtilsTest {

    @Test
    public void instantiateClassTest() throws Exception {
        String message = "Hello World";
        TestClass testClass = BeanUtils.instantiateClass(TestClass.class.getDeclaredConstructor(String.class), message);
        Assert.assertEquals(testClass.getMessage(), message);
    }

    @Test(expected = BeanInstantiationException.class)
    public void instantiateInterfaceTest() throws Exception {
        BeanUtils.instantiateClass(List.class);
    }

    static class TestClass {

        private final String message;

        public TestClass(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}


