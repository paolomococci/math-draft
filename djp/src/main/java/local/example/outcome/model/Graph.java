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
}
