package org.myspring.beans.utils;

import org.junit.Assert;
import org.junit.Test;
import org.myspring.beans.annotations.Component;

import java.util.Set;

@Component
public class MyReflectionUtilsTest {

    @Test
    public void classScanTest() {
        Set<Class> findClasses = MyReflectionUtils.findAnnotatedClasses(MyReflectionUtilsTest.class.getPackageName(), Component.class);
        Assert.assertTrue(findClasses.contains(MyReflectionUtilsTest.class));
    }
}
