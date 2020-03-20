package com.wzw.simcarutillib.util;


public class ClassUtils {

    public static Object getBean(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (Exception ex) {
        }
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception ex) {
            }
        }
        return null;
    }
}

