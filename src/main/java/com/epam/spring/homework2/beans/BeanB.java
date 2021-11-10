package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
    private String name ;
    private int value ;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
