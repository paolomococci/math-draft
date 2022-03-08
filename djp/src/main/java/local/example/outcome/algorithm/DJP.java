package local.example.outcome.algorithm;

import local.example.outcome.model.Graph;

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
        // TODO
    }

    public String minimumSpanningTree() {
        // TODO
        return "";
    }

    public boolean isDisconnected() {
        // TODO
        return false;
    }
}
