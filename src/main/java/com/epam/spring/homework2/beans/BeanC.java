package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class BeanC implements Bean{
    @Value("${beanC.name}")
    private String name ;

    @Value("${beanC.value}")
    private int value ;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void customInitMethod(){
        System.out.println(this.getClass().getSimpleName() + " - customInitMethod()");
    }

    public void customDestroyMethod(){
        System.out.println(this.getClass().getSimpleName() + " - customDestroyMethod()");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
