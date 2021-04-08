package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.dto.BrandDTO;
import edu.step.ecommerce.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandDTO save(BrandDTO brandDTO) {
        final Brand newBrand = new Brand();
        newBrand.setId(brandDTO.getId());
        newBrand.setName(brandDTO.getName());
        newBrand.setDescription(brandDTO.getDescription());

        return BrandDTO.from(brandRepository.save(newBrand));
    }

    public List<BrandDTO> findAll() {
        return this.brandRepository.findAll()
                .stream()
                .map(brand -> BrandDTO.from(brand))
                .collect(Collectors.toList());
    }
}
