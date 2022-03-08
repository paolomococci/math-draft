package local.example.outcome.algorithm;

import local.example.outcome.model.Edge;
import local.example.outcome.model.Graph;
import local.example.outcome.model.Vertex;

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
        }
        // TODO
    }

    public String minimumSpanningTree() {
        // TODO
        return "";
    }

    public boolean isDisconnected() {
        for (Vertex vertex : this.graph.vertices) {
            if (!vertex.isVisited())
                return true;
        }
        return false;
    }
}
