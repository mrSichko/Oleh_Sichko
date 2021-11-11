package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.epam.spring.homework2.beans")
public class BeansConfig {

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

}
