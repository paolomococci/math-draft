package local.example.outcome.model;

import java.util.HashMap;
import java.util.Map;

public class Vertex {

    public String label = "";
    public Map<Vertex, Edge> edges = new HashMap<>();
    public boolean visited = false;
}
