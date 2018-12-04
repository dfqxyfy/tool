package cn.ccs.classloader;

import sun.nio.ch.Net;

import java.net.URL;
import java.net.URLClassLoader;

public class SuperClassLoader {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        ClassLoader classLoader = SuperClassLoader.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

        System.out.println(Object.class.getClassLoader());
        System.out.println(Net.class.getClassLoader());

        System.out.println(System.getProperty("java.class.path"));

        URL[] extURLs = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
        for (int i = 0; i < extURLs.length; i++) {
            System.out.println(extURLs[i]);
        }
    }
}
