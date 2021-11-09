package com.epam.spring.homework1.pet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PetConfig {
    @Bean
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

    @Bean
    public Cheetah cheetah(){
        return new Cheetah();
    }

    @Bean
    public Spider spider(){
        return new Spider();
    }
}
