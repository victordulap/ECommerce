package edu.step.ecommerce.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Size {
    /*
		"id": "Int",
		"size": "String",
		"items": "[]Item ManyToMany"
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String size;

    @ManyToMany
    private Set<Item> items;

    public Size() {
    }

    public Size(Integer id, String size) {
        this.id = id;
        this.size = size;
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
