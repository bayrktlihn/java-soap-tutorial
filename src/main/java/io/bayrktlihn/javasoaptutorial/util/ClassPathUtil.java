package io.bayrktlihn.javasoaptutorial.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClassPathUtil {

    public static InputStream getInputStream(String name) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        return contextClassLoader.getResourceAsStream(name);
    }


}