package edu.step.ecommerce.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
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
		+ "category": "Category ManyToOne",
		+ "tags": "[]Tag ManyToMany (used for easier searching)"
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private Boolean gender;

    @ManyToOne
    private Brand brand;
    @ManyToMany
    private Set<Size> sizes;
    @ManyToOne
    private Color color;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Set<Tag> tags;

    public Item() {}

    public Item(Integer id, String name, String description, Integer stock, Double price, Boolean gender) {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
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

    public Set<Size> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
