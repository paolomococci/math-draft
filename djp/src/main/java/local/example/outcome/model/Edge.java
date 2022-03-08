package local.example.outcome.model;

public class Edge {

    public int weight = Integer.MAX_VALUE;
    public boolean included = false;
    public boolean highlighted = false;

    public Edge() {
    }

    public Edge(int weight) {
        this.weight = weight;
    }

    public Edge(int weight, boolean included) {
        this.weight = weight;
        this.included = included;
    }

    public Edge(int weight, boolean included, boolean highlighted) {
        this.weight = weight;
        this.included = included;
        this.highlighted = highlighted;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }
}
