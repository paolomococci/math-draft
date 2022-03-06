package local.example.outcome.model;

import java.util.HashMap;
import java.util.Map;

public class Vertex {

    public String label = "";
    public Map<Vertex, Edge> edges = new HashMap<>();
    public boolean visited = false;

    public Vertex() {
    }

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(String label, Map<Vertex, Edge> edges, boolean visited) {
        this.label = label;
        this.edges = edges;
        this.visited = visited;
    }
}
