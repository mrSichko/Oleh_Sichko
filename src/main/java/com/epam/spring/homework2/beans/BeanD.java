package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD implements Bean {
    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
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

    public void customDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " - customDestroyMethod()");
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
