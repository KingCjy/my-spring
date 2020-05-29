package org.myspring.beans.utils;

import org.junit.Assert;
import org.junit.Test;
import org.myspring.beans.annotations.Component;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.util.Set;

@Component
public class ReflectionsTest {
    @Test
    public void reflectionsScanClassTest() {
        Reflections reflections = new Reflections(ReflectionsTest.class.getPackageName());
        Set<Class<?>> findClasses = reflections.getTypesAnnotatedWith(Component.class);
        Assert.assertTrue(findClasses.contains(ReflectionsTest.class));
    }
}
