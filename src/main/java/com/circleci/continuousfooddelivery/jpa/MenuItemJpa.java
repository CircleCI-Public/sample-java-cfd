package com.circleci.continuousfooddelivery.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menu_item")
public class MenuItemJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_item_seq")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "image_id")
    private int imageId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "cartItems")
    @JsonIgnore
    private Set<CartJpa> carts;

    public MenuItemJpa(String name, String description, float price, int imageId) {
        this.description = description;
        this.price = price;
        this.imageId = imageId;
        this.name = name;
    }

    public MenuItemJpa() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int image_id) {
        this.imageId = image_id;
    }

    public Set<CartJpa> getCarts() {
        return carts;
    }

    public void addToCart(CartJpa cart) {
        this.carts.add(cart);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
