package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.Item;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrandDTO {
    private Integer id;
    private String name;
    private String description;

    private List<Integer> items;

    public BrandDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public static BrandDTO from(Brand brand) {
        final BrandDTO dto = new BrandDTO();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        dto.setDescription(brand.getDescription());
        if (brand.getItems() != null) {
            final List<Integer> ids = brand.getItems()
                    .stream()
                    .map(item -> item.getId())
                    .collect(Collectors.toList());
            dto.setItems(ids);
        }

        return dto;
    }
}
