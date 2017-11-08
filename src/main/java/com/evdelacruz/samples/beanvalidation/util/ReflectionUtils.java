package com.evdelacruz.samples.beanvalidation.util;

import java.lang.reflect.Constructor;

public final class ReflectionUtils {

    static public Object instantiate(String className) {
        Object obj;
        try {
            Class<?> clazz = Class.forName(className);
            obj = clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            obj = null;
        }
        return obj;
    }

    static public Object instantiate(Object topLevelInstance, Class<?> innerClass) throws Exception {
        Constructor<?> ctor = innerClass.getDeclaredConstructor(topLevelInstance.getClass());
        return ctor.newInstance(topLevelInstance);
    }

    private ReflectionUtils() {
        throw new AssertionError("No \".......ReflectionUtils\" instances for you!");
    }
}
