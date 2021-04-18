package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Color;
import edu.step.ecommerce.model.Item;

import javax.persistence.OneToMany;
import java.util.Set;
import java.util.stream.Collectors;

public class ColorDTO {
    private Integer id;
    private String color;

    private Set<Integer> items;

    public ColorDTO() {
    }

    public ColorDTO(Integer id, String color) {
        this.id = id;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Integer> getItems() {
        return items;
    }

    public void setItems(Set<Integer> items) {
        this.items = items;
    }

    public static ColorDTO from(Color color) {
        final ColorDTO dto = new ColorDTO(color.getId(), color.getColor());
        if (color.getItems() != null) {
            final Set<Integer> ids = color.getItems()
                    .stream()
                    .map(item -> item.getId())
                    .collect(Collectors.toSet());
            dto.setItems(ids);
        }

        return dto;
    }
}
