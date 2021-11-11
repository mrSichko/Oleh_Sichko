package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.epam.spring.homework2.beans")
public class BeansConfig {
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

}
