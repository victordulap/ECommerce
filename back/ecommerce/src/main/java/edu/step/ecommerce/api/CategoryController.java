package edu.step.ecommerce.api;

import edu.step.ecommerce.model.dto.CategoryDTO;
import edu.step.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }
}
