package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class BeanB implements Bean {
    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void customInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customInitMethod()");
    }

    public void otherInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " - otherInitMethod()");
    }

    public void customDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customDestroyMethod()");
    }


    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
