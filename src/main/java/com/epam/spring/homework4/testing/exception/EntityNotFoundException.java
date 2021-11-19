package com.epam.spring.homework4.testing.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(){
        super();
    }

    public EntityNotFoundException(String massage){
        super(massage);
    }
}
