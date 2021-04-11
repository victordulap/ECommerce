package edu.step.ecommerce.service.exception;

public class ItemNotFoundException extends EntityNotFoundException {
    public ItemNotFoundException(Integer id) {
        super("Item", id);
    }
}
