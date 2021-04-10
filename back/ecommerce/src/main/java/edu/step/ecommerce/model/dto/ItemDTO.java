package edu.step.ecommerce.model.dto;

import edu.step.ecommerce.model.Brand;
import edu.step.ecommerce.model.Item;

import javax.persistence.ManyToOne;

public class ItemDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;

    private Integer brand;

    public ItemDTO() {}

    public ItemDTO(Integer id, String name, String description, Integer stock, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
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

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static ItemDTO from(Item item) {
        final ItemDTO dto = new ItemDTO(item.getId(), item.getName(), item.getDescription(),
                item.getStock(), item.getPrice());
        if(item.getBrand() != null) {
            dto.setBrand(item.getBrand().getId());
        }
        return dto;
    }
}
