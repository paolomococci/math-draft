package local.example.outcome.model;

import java.util.*;

public class Assortment {
    
    public final List<Item> items;

    public Assortment() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        this.items.add(item);
    }

    public Item get(int index) {
        return this.items.get(index);
    }

    public List<Item> toList() {
        return this.items.stream().toList();
    }
}
