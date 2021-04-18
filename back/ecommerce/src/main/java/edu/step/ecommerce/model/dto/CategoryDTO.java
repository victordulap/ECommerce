package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Category;
import edu.step.ecommerce.model.Item;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryDTO {
    private Integer id;
    private String name;

    private Set<Integer> items;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Integer> getItems() {
        return items;
    }

    public void setItems(Set<Integer> items) {
        this.items = items;
    }

    public static CategoryDTO from(Category category) {
        final CategoryDTO dto = new CategoryDTO(category.getId(), category.getName());
        if(category.getItems() != null) {
            final Set<Integer> ids = category.getItems()
                    .stream()
                    .map(item -> item.getId())
                    .collect(Collectors.toSet());
            dto.setItems(ids);
        }

        return dto;
    }
}
