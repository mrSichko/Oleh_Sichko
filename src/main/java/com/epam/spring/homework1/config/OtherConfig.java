package com.epam.spring.homework1.config;

import com.epam.spring.homework1.beans.BeanA;
import com.epam.spring.homework1.beans.BeanB;
import com.epam.spring.homework1.other.OtherBeanA;
import com.epam.spring.homework1.other.OtherBeanB;
import com.epam.spring.homework1.other.OtherBeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.epam.spring.homework1.other");
public class OtherConfig {

    @Bean
    public OtherBeanA otherBeanA() {
        return new OtherBeanA(new BeanA());
    }

    @Bean
    public OtherBeanB otherBeanB() {
        OtherBeanB otherBeanB = new OtherBeanB();
        otherBeanB.setBeanB(new BeanB());
        return otherBeanB;
    }

    @Bean
    public OtherBeanC otherBeanC() {
        return new OtherBeanC();
    }
}
