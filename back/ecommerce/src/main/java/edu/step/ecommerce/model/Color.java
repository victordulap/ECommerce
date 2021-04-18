package edu.step.ecommerce.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Color {
    /*
		"id": "Int",
		"color": "String",
		"items": "[]Item OneToMany"
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String color;

    @OneToMany
    private Set<Item> items;

    public Color() {
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
