package edu.step.ecommerce.api;

import edu.step.ecommerce.model.dto.TagDTO;
import edu.step.ecommerce.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody TagDTO tag) {
        return ResponseEntity.ok(this.tagService.save(tag));
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.tagService.findAll());
    }
}
