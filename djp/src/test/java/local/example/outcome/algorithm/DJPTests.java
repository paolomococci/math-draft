package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import local.example.outcome.model.Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DJPTests {

    @Test
    public void createVoidGraphTest() {
        Graph graph = new Graph();
        Assertions.assertEquals(0, graph.vertices.size());
    }
}
