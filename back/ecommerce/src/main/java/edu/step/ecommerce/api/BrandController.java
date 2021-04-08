package edu.step.ecommerce.api;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.dto.BrandDTO;
import edu.step.ecommerce.service.BrandService;
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
}
