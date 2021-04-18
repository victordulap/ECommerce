package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Category;
import edu.step.ecommerce.model.dto.CategoryDTO;
import edu.step.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        final Category category = new Category(categoryDTO.getId(), categoryDTO.getName());
        return CategoryDTO.from(categoryRepository.save(category));
    }

    public Set<CategoryDTO> findAll() {
        return this.categoryRepository.findAll()
                .stream()
                .map(category -> CategoryDTO.from(category))
                .collect(Collectors.toSet());
    }
}
