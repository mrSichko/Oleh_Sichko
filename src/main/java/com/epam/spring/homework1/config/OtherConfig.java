package com.epam.spring.homework1.config;

import com.epam.spring.homework1.beans.BeanA;
import com.epam.spring.homework1.beans.BeanB;
import com.epam.spring.homework1.other.OtherBeanA;
import com.epam.spring.homework1.other.OtherBeanB;
import com.epam.spring.homework1.other.OtherBeanC;
import com.epam.spring.homework1.pet.PetConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.epam.spring.homework1.beans")
@ComponentScan("com.epam.spring.homework1.other")
@Import(PetConfig.class)
public class OtherConfig {

    @Bean
    public OtherBeanA otherBeanA(BeanA beanA) {
        return new OtherBeanA(beanA);
    }

    @Bean
    public OtherBeanB otherBeanB() {
        OtherBeanB otherBeanB = new OtherBeanB();
        return otherBeanB;
    }

    @Bean
    public OtherBeanC otherBeanC() {
        return new OtherBeanC();
    }
}
