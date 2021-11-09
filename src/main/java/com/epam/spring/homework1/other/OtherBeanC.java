package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanC {
    @Autowired
    private BeanC beanC;

    public OtherBeanC() {
     this.beanC = new BeanC();
        System.out.println(beanC);
    }
}
