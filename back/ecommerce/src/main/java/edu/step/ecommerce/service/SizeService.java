package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Size;
import edu.step.ecommerce.model.dto.SizeDTO;
import edu.step.ecommerce.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizeService {
    private SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public SizeDTO save(SizeDTO sizeDTO) {
        final Size size = new Size(sizeDTO.getId(), sizeDTO.getSize());

        final Size savedSize = this.sizeRepository.save(size);

        return SizeDTO.from(savedSize);
    }

    public List<SizeDTO> findAll() {
        return this.sizeRepository.findAll()
                .stream()
                .map(size -> SizeDTO.from(size))
                .collect(Collectors.toList());
    }

}
