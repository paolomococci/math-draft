package local.example.outcome.algorithm;

import local.example.outcome.model.Centroid;
import local.example.outcome.model.Distance;
import local.example.outcome.model.Record;

import java.util.*;
import java.util.stream.Collectors;

public interface ClusteringMeans {

    static final Random random = new Random();

    static Map<Centroid, List<Record>> tieDown(
            List<Record> records,
            int numberOfClusters,
            Distance distance,
            int limitNumberOfIterations
    ) {
        // TODO: 27/09/22
        return null;
    }

    private static void checkPreconditions(
            List<Record> records,
            int numberOfClusters,
            Distance distance,
            int limitNumberOfIterations
    ) {
        if (records == null || records.isEmpty())
            throw new IllegalArgumentException("the record list can't be empty");
        if (numberOfClusters <= 1)
            throw new IllegalArgumentException("clusters must be at least more than one");
        if (distance == null)
            throw new IllegalArgumentException("the distance list can't be null");
        if (limitNumberOfIterations <= 0)
            throw new IllegalArgumentException("limitNumberOfIterations must be at least more than zero");
    }

    private static void assignToCluster(
            Map<Centroid, List<Record>> clusters,
            Record record,
            Centroid centroid
    ) {
        clusters.compute(
                centroid,
                (key, list) -> {
                    if (list == null)
                        list = new ArrayList<>();
                    list.add(record);
                    return list;
                }
        );
    }

    private static Centroid nearestCentroid(
            Record record,
            List<Centroid> centroids,
            Distance distance
    ) {
        double minDistance = Double.MAX_VALUE;
        Centroid nearestCentroid = null;
        for (Centroid centroid : centroids) {
            double currentDistance = distance.compute(
                    record.features,
                    centroid.coordinates
            );
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                nearestCentroid = centroid;
            }
        }
        return nearestCentroid;
    }

    private static Centroid average(
            Centroid centroid,
            List<Record> records
    ) {
        if (records == null || records.isEmpty())
            return centroid;
        Map<String, Double> average = centroid.coordinates;
        records.stream().flatMap(
                record -> record.features.keySet().stream()
        ).forEach(
                s -> average.put(s, 0.0)
        );
        return null;
    }

    private static List<Centroid> relocateCentroids(
            Map<Centroid, List<Record>> clusters
    ) {
        // TODO: 27/09/22
        return null;
    }

    private static List<Centroid> randomCentroids(
            List<Record> records,
            int numberOfClusters
    ) {
        List<Centroid> centroids = new ArrayList<>();
        Map<String, Double> maxValues = new HashMap<>();
        Map<String, Double> minValues = new HashMap<>();
        for (Record record : records) {
            record.features.forEach(
                    (key, value) -> {
                        maxValues.compute(
                                key, (k1, max) -> max == null || value > max ? value : max
                        );
                        minValues.compute(
                                key, (k1, min) -> min == null || value < min ? value : min
                        );
                    }
            );
        }
        Set<String> attributes = records.stream().flatMap(
                record -> record.features.keySet().stream()
        ).collect(Collectors.toSet());
        for (int i = 0; i < numberOfClusters; i++) {
            Map<String, Double> coordinates = new HashMap<>();
            for (String attribute : attributes) {
                double max = maxValues.get(attribute);
                double min = minValues.get(attribute);
                coordinates.put(
                        attribute,
                        random.nextDouble() * (max - min) + min
                );
            }
            centroids.add(new Centroid(coordinates));
        }
        return centroids;
    }
}
