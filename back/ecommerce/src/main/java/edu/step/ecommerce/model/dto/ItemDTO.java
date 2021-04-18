package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.Item;

import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemDTO {
    /*
        + "id": "Int",
		+ "name": "String",
		+ "description": "String",
		+ "price": "Double (in usd)",
		+ "stock": "Int (how many left)",
       	+ "gender": "Boolean (true - male, false - female)",
        + "brand": "Brand ManyToOne",
		+ "sizes": "[]Size ManyToMany",
		+ "color": "Color ManyToOne",
		"category": "Category ManyToOne",
		"tags": "[]Tag ManyToMany (used for easier searching)"
     */

    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private Boolean gender;

    private Integer brand;
    private Set<Integer> sizes;
    private Integer color;

    public ItemDTO() {}

    public ItemDTO(Integer id, String name, String description, Integer stock, Double price, Boolean gender) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.gender = gender;
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

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getStock() {
        return stock;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Integer> sizes) {
        this.sizes = sizes;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public static ItemDTO from(Item item) {
        final ItemDTO dto = new ItemDTO(item.getId(), item.getName(), item.getDescription(),
                item.getStock(), item.getPrice(), item.getGender());
        if(item.getBrand() != null) {
            dto.setBrand(item.getBrand().getId());
        }
        if (item.getSizes() != null) {
            final Set<Integer> sizeIds = item.getSizes()
                    .stream()
                    .map(size -> size.getId())
                    .collect(Collectors.toSet());
            dto.setSizes(sizeIds);
        }
        if (item.getColor() != null) {
            dto.setColor(item.getColor().getId());
        }

        return dto;
    }
}
