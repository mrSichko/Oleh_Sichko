package com.epam.spring.homework2;

import com.epam.spring.homework2.config.BeansConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String bean : beanDefinitionNames) {
            System.out.println(context.getBean(bean));
        }

        context.close();
    }
}
