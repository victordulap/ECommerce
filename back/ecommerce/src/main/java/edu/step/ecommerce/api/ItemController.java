package edu.step.ecommerce.api;

import edu.step.ecommerce.model.dto.ItemDTO;
import edu.step.ecommerce.service.ItemService;
import edu.step.ecommerce.service.exception.BrandNotFoundException;
import edu.step.ecommerce.service.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ItemDTO item) {
        try {
            ItemDTO savedItem = this.itemService.save(item);
            return ResponseEntity.ok(savedItem);
        } catch (BrandNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<ItemDTO> items = this.itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            ItemDTO deletedItem = this.itemService.delete(id);
            return ResponseEntity.ok(deletedItem);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

//    @PutMapping
//    public ResponseEntity update(@RequestBody ItemDTO item) {
//        try {
//          return ResponseEntity.ok(this.itemService.update(item));
//        }
//    }
}
