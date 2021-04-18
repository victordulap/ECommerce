package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Item;
import edu.step.ecommerce.model.Size;

import java.util.Set;
import java.util.stream.Collectors;

public class SizeDTO {
    private Integer id;
    private String size;

    private Set<Integer> items;

    public SizeDTO() {
    }

    public SizeDTO(Integer id, String size) {
        this.id = id;
        this.size = size;
    }


    public static SizeDTO from(Size size) {
        final SizeDTO dto = new SizeDTO();
        dto.setId(size.getId());
        dto.setSize(size.getSize());
        if (size.getItems() != null) {
            final Set<Integer> ids = size.getItems()
                    .stream()
                    .map(item -> item.getId())
                    .collect(Collectors.toSet());
            dto.setItems(ids);
        }

        return dto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Set<Integer> getItems() {
        return items;
    }

    public void setItems(Set<Integer> items) {
        this.items = items;
    }
}
