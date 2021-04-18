package edu.step.ecommerce.api;

import edu.step.ecommerce.model.dto.SizeDTO;
import edu.step.ecommerce.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/size")
public class SizeController {
    private final SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SizeDTO size) {
        SizeDTO savedSize = this.sizeService.save(size);
        return ResponseEntity.ok(savedSize);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.sizeService.findAll());
    }
}
