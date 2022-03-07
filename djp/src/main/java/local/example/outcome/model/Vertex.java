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
        if (this.edges.containsKey(vertex))
            if (edge.getWeight() < this.edges.get(vertex).getWeight())
                this.edges.replace(vertex, edge);
        this.edges.put(vertex, edge);
    }

    public Map<Vertex, Edge> getEdges() {
        return edges;
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
