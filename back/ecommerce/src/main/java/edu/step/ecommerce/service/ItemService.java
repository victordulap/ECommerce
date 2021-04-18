package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.Item;
import edu.step.ecommerce.model.dto.ItemDTO;
import edu.step.ecommerce.repository.BrandRepository;
import edu.step.ecommerce.repository.ItemRepository;
import edu.step.ecommerce.service.exception.BrandNotFoundException;
import edu.step.ecommerce.service.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private BrandRepository brandRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, BrandRepository brandRepository) {
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
    }

    public ItemDTO save(ItemDTO itemDTO) throws BrandNotFoundException {
        final Item item = new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getDescription(),
                itemDTO.getStock(), itemDTO.getPrice(), itemDTO.getGender());
        Brand linkedBrand = null;
        Integer brandId = itemDTO.getBrand();
        if (brandId != null) {
            linkedBrand = this.brandRepository.findById(brandId).orElseThrow(() -> new BrandNotFoundException(brandId));
        }
        item.setBrand(linkedBrand);

        final Item savedItem = this.itemRepository.save(item);

        if(linkedBrand.getItems() == null) {
            linkedBrand.setItems(new HashSet<>());
        }
        linkedBrand.getItems().add(savedItem);
        this.brandRepository.save(linkedBrand);

        return ItemDTO.from(item);
    }

    public List<ItemDTO> findAll() {
        return this.itemRepository.findAll().stream().map(item -> ItemDTO.from(item)).collect(Collectors.toList());
    }

    public ItemDTO delete(Integer id) throws ItemNotFoundException {
        final Item item = this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        ItemDTO deletedItem = ItemDTO.from(item);
        this.itemRepository.delete(item);
        return deletedItem;
    }

//    public ItemDTO update(ItemDTO newItemData) throws ItemNotFoundException {
//        final Integer id = newItemData.getId();
//        final Item item = this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
//
//    }
}
