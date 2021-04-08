package edu.step.ecommerce.service.exception;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String entity, Integer id) {
        super(entity + " with id=" + id + " does not exist");
    }
}
