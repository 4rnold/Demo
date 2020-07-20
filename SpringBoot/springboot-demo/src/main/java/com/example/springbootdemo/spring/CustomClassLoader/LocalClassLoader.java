package com.example.springbootdemo.spring.CustomClassLoader;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LocalClassLoader extends ClassLoader {

    private String path = "c:/test/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> cls = findLoadedClass(name);
        if (cls != null) {
            return cls;
        }

        if (!name.endsWith(".Key")) {
            return super.loadClass(name);
        }

        try {
            InputStream is = new FileInputStream(path + name.replace(".", "/") + ".class");
            byte[] bytes = IOUtils.toByteArray(is);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.loadClass(name);
    }
}