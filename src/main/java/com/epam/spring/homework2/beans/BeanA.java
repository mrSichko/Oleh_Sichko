package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements Bean, InitializingBean, DisposableBean {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - afterPropertiesSet()");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
