package edu.step.ecommerce.service.exception;

import edu.step.ecommerce.service.exception.EntityNotFoundException;

public class BrandNotFoundException extends EntityNotFoundException {
    public BrandNotFoundException(Integer id) {
        super("Brand", id);
    }
}
