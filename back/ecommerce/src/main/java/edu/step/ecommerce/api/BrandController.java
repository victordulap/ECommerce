package edu.step.ecommerce.api;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.dto.BrandDTO;
import edu.step.ecommerce.service.BrandService;
import edu.step.ecommerce.service.exception.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BrandDTO brand) {
        return ResponseEntity.ok(brandService.save(brand));
    }

    @GetMapping
    public  ResponseEntity getAll() {
        final List<BrandDTO> brands = this.brandService.findAll();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(this.brandService.findById(id));
        } catch (BrandNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody BrandDTO brandToUpdate) {
        try {
            return ResponseEntity.ok(this.brandService.update(brandToUpdate));
        } catch (BrandNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            BrandDTO deletedBrand = this.brandService.delete(id);
            return ResponseEntity.ok(deletedBrand);
        } catch (BrandNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
