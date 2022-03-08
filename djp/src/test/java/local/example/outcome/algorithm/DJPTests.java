package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import local.example.outcome.model.Edge;
import local.example.outcome.model.Graph;
import local.example.outcome.model.Vertex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DJPTests {

    @Test
    public void createVoidGraphTest() {
        Graph graph = new Graph();
        Assertions.assertEquals(0, graph.vertices.size());
    }

    @Test
    public void createSampleGraphTest() {
        Graph graph = new Graph();
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Edge edgeAB = new Edge(2);
        Edge edgeAC = new Edge(3);
        Edge edgeBC = new Edge(2);
        Edge edgeBE = new Edge(5);
        Edge edgeCD = new Edge(1);
        Edge edgeCE = new Edge(1);
        vertexA.add(vertexB, edgeAB);
        vertexB.add(vertexA, edgeAB);
        vertexA.add(vertexC, edgeAC);
        vertexC.add(vertexA, edgeAC);
        vertexB.add(vertexC, edgeBC);
        vertexC.add(vertexB, edgeBC);
        vertexB.add(vertexE, edgeBE);
        vertexE.add(vertexB, edgeBE);
        vertexC.add(vertexD, edgeCD);
        vertexD.add(vertexC, edgeCD);
        vertexC.add(vertexE, edgeCE);
        vertexE.add(vertexC, edgeCE);
        graph.add(vertexA);
        graph.add(vertexB);
        graph.add(vertexC);
        graph.add(vertexD);
        graph.add(vertexE);
        Assertions.assertEquals(5, graph.vertices.size());
    }

    @Test
    public void minimumSpanningTreeTest() {
        Graph graph = new Graph();
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Edge edgeAB = new Edge(2);
        Edge edgeAC = new Edge(3);
        Edge edgeBC = new Edge(2);
        Edge edgeBE = new Edge(5);
        Edge edgeCD = new Edge(1);
        Edge edgeCE = new Edge(1);
        vertexA.add(vertexB, edgeAB);
        vertexB.add(vertexA, edgeAB);
        vertexA.add(vertexC, edgeAC);
        vertexC.add(vertexA, edgeAC);
        vertexB.add(vertexC, edgeBC);
        vertexC.add(vertexB, edgeBC);
        vertexB.add(vertexE, edgeBE);
        vertexE.add(vertexB, edgeBE);
        vertexC.add(vertexD, edgeCD);
        vertexD.add(vertexC, edgeCD);
        vertexC.add(vertexE, edgeCE);
        vertexE.add(vertexC, edgeCE);
        graph.add(vertexA);
        graph.add(vertexB);
        graph.add(vertexC);
        graph.add(vertexD);
        graph.add(vertexE);
        DJP djp = new DJP(graph);
        djp.pathFind();
        Assertions.assertNotNull(djp.minimumSpanningTree());
    }
}
