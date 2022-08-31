package local.example.outcome.algorithm;

import local.example.outcome.model.Edge;
import local.example.outcome.model.Graph;
import local.example.outcome.model.Vertex;

import org.apache.commons.math3.util.Pair;

public class DJP {

    public Graph graph;

    public DJP(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void pathFind() {
        if (this.graph.vertices.size() > 0)
            graph.vertices.get(0).setVisited(true);
        while (this.isDisconnected()) {
            Edge nextMin = new Edge();
            Vertex nextVertex = this.graph.vertices.get(0);
            for (Vertex vertex : this.graph.vertices) {
                if (vertex.isVisited()) {
                    Pair<Vertex, Edge> pairCandidate = vertex.nextImprove();
                    if (pairCandidate.getValue().getWeight() < nextMin.getWeight()) {
                        nextMin = pairCandidate.getValue();
                        nextVertex = pairCandidate.getKey();
                    }
                }
            }
            nextMin.setIncluded(true);
            nextVertex.setVisited(true);
        }
    }

    public String minimumSpanningTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Vertex vertex : this.graph.vertices) {
            stringBuilder.append(vertex.computed());
        }
        return stringBuilder.toString();
    }

    public boolean isDisconnected() {
        for (Vertex vertex : this.graph.vertices) {
            if (!vertex.isVisited())
                return true;
        }
        return false;
    }

    public String original() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Vertex vertex : this.getGraph().vertices) {
            stringBuilder.append(vertex.original());
        }
        return stringBuilder.toString();
    }
}
