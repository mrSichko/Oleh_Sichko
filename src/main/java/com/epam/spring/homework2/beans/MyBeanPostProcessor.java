package com.epam.spring.homework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Bean) {
            if (((Bean) bean).getName() != null && ((Bean) bean).getValue() > 0) {
                System.out.println(beanName + " valid!");
            }
            else {
                System.out.println(beanName + " not valid!");
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
