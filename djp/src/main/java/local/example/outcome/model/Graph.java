package local.example.outcome.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public final List<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void add(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Vertex> toList() {
        return this.vertices.stream().toList();
    }

    public Vertex[] toArray() {
        Vertex[] arrayOfVertices = new Vertex[this.vertices.size()];
        arrayOfVertices = this.vertices.toArray(arrayOfVertices);
        return arrayOfVertices;
    }

    public void fromArray(Vertex[] arrayOfVertices) {
        this.vertices.clear();
        this.vertices.addAll(List.of(arrayOfVertices));
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                '}';
    }
}
