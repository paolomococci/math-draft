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

    public Vertex(String label, Map<Vertex, Edge> edges) {
        this.label = label;
        this.edges = edges;
    }

    public Vertex(String label, Map<Vertex, Edge> edges, boolean visited) {
        this.label = label;
        this.edges = edges;
        this.visited = visited;
    }

    public void add(Vertex vertex, Edge edge) {
        this.edges.put(vertex, edge);
    }

    public void remove(Vertex vertex) {
        this.edges.remove(vertex);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
