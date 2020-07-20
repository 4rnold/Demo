package com.example.springbootdemo.spring.logback_desensitization;

import javassist.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicToStringObject {
 
    public static <T> StringDesc getStringDesc(Class<T> clazz) {
        StringDesc stringDesc = null;
        try {
            ClassPool pool = ClassPool.getDefault();
            pool.insertClassPath(new ClassClassPath(StringDesc.class));
            pool.insertClassPath(new ClassClassPath(clazz));
            CtClass stringDescCt = pool.get(StringDesc.class.getName());
            // beanStringDescCt是动态生成的类
            CtClass beanStringDescCt = pool.makeClass(clazz.getSimpleName() + "StringDesc");
            // 设置动态类的父类是StringDesc
            beanStringDescCt.setSuperclass(stringDescCt);
            // strBuilder用于构建toString方法体
            StringBuilder strBuilder = new StringBuilder();
            String beanClassName = clazz.getName();
            strBuilder.append("java.lang.StringBuffer sb = new java.lang.StringBuffer();");
            // 输出bean类名
            strBuilder.append("sb.append(\"" + beanClassName + "[\");");
            CtClass beanCt = pool.get(beanClassName);
            CtField[] fields = beanCt.getDeclaredFields();
            for (CtField field : fields) {
                String fieldName = field.getName();
                try {
                    Object annotation = field.getAnnotation(Desensitization.class);
                    String method = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    if (annotation != null) {
                        Desensitization d = (Desensitization)annotation;
                        strBuilder.append("sb.append(\"" + fieldName + "=\" +desensitization(((" + beanClassName + ")bean)." + method + "(), \""+d.type()+"\")+ \", \");");
                    }else {
                        strBuilder.append("sb.append(\"" + fieldName + "=\" +((" + beanClassName + ")bean)." + method + "() + \", \");");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            strBuilder.append("sb.append(\"]\");");
            strBuilder.append("return sb.toString();");
            // 动态构建toString方法
            CtMethod sm = new CtMethod(pool.get("java.lang.String"), "toString", null, beanStringDescCt);
            // 设置方法体
            String toString = strBuilder.toString();
            System.out.println("toString: " + toString);
            sm.setBody("{" + toString + "}");
            // 将toString方法添加到动态类中
            beanStringDescCt.addMethod(sm);
            // 生成动态类实例
            stringDesc = (StringDesc) beanStringDescCt.toClass().newInstance();
        } catch (IllegalAccessException e) {
            log.info("日志脱敏生成toString方法失败：", e);
        } catch (InstantiationException e) {
            log.info("日志脱敏生成toString方法失败：", e);
        } catch (CannotCompileException e) {
            log.info("日志脱敏生成toString方法失败：", e);
        } catch (NotFoundException e) {
            log.info("日志脱敏生成toString方法失败：", e);
        }
        return stringDesc;
    }
}