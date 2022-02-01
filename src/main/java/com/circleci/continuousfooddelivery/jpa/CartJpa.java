package com.circleci.continuousfooddelivery.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class CartJpa {

    @Id
    private String id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_item",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<MenuItemJpa> cartItems;

    public CartJpa() {
        this.cartItems = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<MenuItemJpa> getItems() {
        return cartItems;
    }

    public void setItems(List<MenuItemJpa> items) {
        this.cartItems = items;
    }

    public void addItem(MenuItemJpa item) {
        this.cartItems.add(item);
    }

    public boolean removeItem(Integer itemId) {
        final Iterator<MenuItemJpa> each = cartItems.iterator();

        while (each.hasNext()) {
            if (itemId.equals(each.next().getId())) {
                each.remove();
                return true;
            }
        }

        return false;
    }
}
