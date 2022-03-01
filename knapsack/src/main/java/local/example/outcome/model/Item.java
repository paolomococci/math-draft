package local.example.outcome.model;

public class Item {

    public String name;
    public Double weight;
    public Double value;
    public Integer availability;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Double weight, Double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}
