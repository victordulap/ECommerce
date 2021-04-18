package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Color;
import edu.step.ecommerce.model.dto.ColorDTO;
import edu.step.ecommerce.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ColorService {
    private ColorRepository colorRepository;

    @Autowired

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public ColorDTO save(ColorDTO colorDTO) {
        final Color newColor = new Color(colorDTO.getId(), colorDTO.getColor());
        return ColorDTO.from(colorRepository.save(newColor));
    }

    public Set<ColorDTO> findAll() {
        return this.colorRepository.findAll()
                .stream()
                .map(color -> ColorDTO.from(color))
                .collect(Collectors.toSet());
    }

}
