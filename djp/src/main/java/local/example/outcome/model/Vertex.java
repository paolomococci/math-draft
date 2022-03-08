package local.example.outcome.model;

import org.apache.commons.math3.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
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
        if (this.edges.containsKey(vertex)) {
            if (edge.getWeight() < this.edges.get(vertex).getWeight())
                this.edges.replace(vertex, edge);
        } else {
            this.edges.put(vertex, edge);
        }
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

    public Pair<Vertex, Edge> nextImprove() {
        Edge minEdge = new Edge();
        Vertex nextVertex = this;
        for (Map.Entry<Vertex, Edge> entry : this.edges.entrySet()) {
            if (!entry.getKey().isVisited()) {
                if (!entry.getValue().isIncluded()) {
                    if (entry.getValue().getWeight() < minEdge.getWeight()) {
                        minEdge = entry.getValue();
                        nextVertex = entry.getKey();
                    }
                }
            }
        }
        return new Pair<>(nextVertex, minEdge);
    }

    public String original() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Vertex, Edge> vertexEdgeEntry : this.edges.entrySet()) {
            if (!vertexEdgeEntry.getValue().isHighlighted()) {
                stringBuilder.append(this.getLabel());
                stringBuilder.append("-");
                stringBuilder.append(vertexEdgeEntry.getValue().getWeight());
                stringBuilder.append("-");
                stringBuilder.append(vertexEdgeEntry.getKey().getLabel());
                stringBuilder.append("\n");
                vertexEdgeEntry.getValue().setHighlighted(true);
            }
        }
        return stringBuilder.toString();
    }

    public String computed() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.isVisited()) {
            for (Map.Entry<Vertex, Edge> vertexEdgeEntry : this.edges.entrySet()) {
                if (vertexEdgeEntry.getValue().isIncluded()) {
                    if (!vertexEdgeEntry.getValue().isHighlighted()) {
                        stringBuilder.append(this.getLabel());
                        stringBuilder.append("-");
                        stringBuilder.append(vertexEdgeEntry.getValue().getWeight());
                        stringBuilder.append("-");
                        stringBuilder.append(vertexEdgeEntry.getKey().getLabel());
                        stringBuilder.append("\n");
                        vertexEdgeEntry.getValue().setHighlighted(true);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
