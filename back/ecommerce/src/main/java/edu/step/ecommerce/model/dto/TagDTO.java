package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Item;
import edu.step.ecommerce.model.Tag;

import java.util.Set;
import java.util.stream.Collectors;

public class TagDTO {
    private Integer id;
    private String name;

    private Set<Integer> items;

    public TagDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TagDTO() {
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

    public static TagDTO from (Tag tag) {
        final TagDTO dto = new TagDTO(tag.getId(), tag.getName());
        if (tag.getItems() != null) {
            final Set<Integer> ids = tag.getItems()
                    .stream()
                    .map(item -> item.getId())
                    .collect(Collectors.toSet());
            dto.setItems(ids);
        }

        return dto;
    }
}
