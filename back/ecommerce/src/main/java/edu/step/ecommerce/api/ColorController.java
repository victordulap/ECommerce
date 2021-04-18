package edu.step.ecommerce.api;

import edu.step.ecommerce.model.dto.ColorDTO;
import edu.step.ecommerce.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/color")
public class ColorController {
    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ColorDTO color) {
        ColorDTO savedColor = this.colorService.save(color);
        return ResponseEntity.ok(savedColor);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.colorService.findAll());
    }
}
