package org.myspring.beans.utils;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyReflectionUtils {

    public static Set<Class> findAnnotatedClasses(String basePackage, Class<? extends Annotation>... annotations) {
        Reflections reflections = new Reflections(basePackage);
        return getTypeAnnotatedClass(reflections, annotations);
    }

    private static Set<Class> getTypeAnnotatedClass(Reflections reflections, Class<? extends Annotation>... annotations) {
        Set<Class> result = new HashSet<>();

        for (Class<? extends Annotation> annotation : annotations) {
            Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(annotation);

            for (Class<?> annotatedClass : annotatedClasses) {
                if(annotatedClass.isAnnotation() == false && annotatedClass.isInterface() == false) {
                    result.add(annotatedClass);
                }
            }
        }

        return result;
    }
}
