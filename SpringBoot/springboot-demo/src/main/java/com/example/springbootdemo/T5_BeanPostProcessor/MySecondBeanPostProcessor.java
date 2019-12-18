package com.example.springbootdemo.T5_BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * 实现了PriorityOrdered 就对 没有实现接口的BeanpostProcessor起作用。
 */
@Component
//@Order(1)
public class MySecondBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("My2BeanPostProcessor:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("My2BeanPostProcessor:" + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
