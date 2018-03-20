package eu.tjago.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fruit {

    private String name;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
