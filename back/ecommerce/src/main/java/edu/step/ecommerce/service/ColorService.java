package edu.step.ecommerce.service;

import edu.step.ecommerce.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    private ColorRepository colorRepository;

    @Autowired

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }


}
