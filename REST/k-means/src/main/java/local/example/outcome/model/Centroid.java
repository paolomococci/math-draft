package local.example.outcome.model;

import java.util.Map;

public class Centroid {

    public Map<String, Double> coordinates;

    public Centroid() {
    }

    public Centroid(Map<String, Double> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Centroid{" +
                "coordinates=" + coordinates +
                '}';
    }
}
