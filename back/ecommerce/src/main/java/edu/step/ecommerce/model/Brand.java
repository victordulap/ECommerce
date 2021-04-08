package edu.step.ecommerce.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Brand {
    /*
        "id": "Int",
		"name": "String",
		"description": "String",
		"items": "[]Item OneToMany"
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column(length = 500)
    private String description;

    @OneToMany
    private Set<Item> items;

    public Brand() {
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
