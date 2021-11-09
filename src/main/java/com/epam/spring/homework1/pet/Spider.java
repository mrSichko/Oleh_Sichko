package com.epam.spring.homework1.pet;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Spider implements Animal {
    public String getAnimal() {
        return this.getClass().getSimpleName();
    }
}
