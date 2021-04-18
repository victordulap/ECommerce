package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.dto.BrandDTO;
import edu.step.ecommerce.repository.BrandRepository;
import edu.step.ecommerce.service.exception.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public BrandDTO findById(Integer id) throws BrandNotFoundException {
        final Brand brandById = this.brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException(id));
        return BrandDTO.from(brandById);
    }

    public BrandDTO update(BrandDTO newBrandData) throws BrandNotFoundException {
        final Integer id = newBrandData.getId();
        final Brand brand = this.brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException(id));

        String name = newBrandData.getName();
        if (name != null) {
            brand.setName(name);
        }

        String description = newBrandData.getDescription();
        if (description != null) {
            brand.setDescription(description);
        }

        final Brand savedBrand = this.brandRepository.save(brand);
        return BrandDTO.from(savedBrand);
    }

    public BrandDTO delete(Integer id) throws BrandNotFoundException {
        final Brand brand = this.brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException(id));
        BrandDTO deletedBrand = BrandDTO.from(brand);
        this.brandRepository.delete(brand);
        return deletedBrand;
    }

}
