package local.example.outcome.model;

public class Edge {

    public int weight = Integer.MAX_VALUE;
    public boolean included = false;

    public Edge() {
    }

    public Edge(int weight, boolean included) {
        this.weight = weight;
        this.included = included;
    }
}
