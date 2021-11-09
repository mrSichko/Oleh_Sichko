package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Spider.class))
public class PetConfig {

    @Bean
    public Cheetah cheetah() {
        return new Cheetah();
    }

    @Bean
    @Qualifier("cheetahBean")
    public Cheetah getCheetah() {
        return new Cheetah();
    }

    @Bean
    public Cheetah otherCheetah(@Qualifier("cheetahBean") Cheetah cheetah) {
        return cheetah;
    }

}
