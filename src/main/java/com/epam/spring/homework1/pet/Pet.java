package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Pet {
    @Autowired
    public List<Animal> animals;

    public void printPets(){
      animals.forEach(a -> System.out.println(a.getAnimal()));
    }
}
