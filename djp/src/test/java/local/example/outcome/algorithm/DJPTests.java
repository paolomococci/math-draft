package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

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
        Assertions.assertEquals(0, graph.vertices.size());
    }
}
