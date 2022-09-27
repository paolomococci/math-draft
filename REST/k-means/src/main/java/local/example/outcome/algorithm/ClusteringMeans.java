package local.example.outcome.algorithm;

import local.example.outcome.model.Centroid;
import local.example.outcome.model.Distance;
import local.example.outcome.model.Record;

import java.util.List;
import java.util.Map;

public interface ClusteringMeans {

    static Map<Centroid, List<Record>> tieDown(
            List<Record> records,
            int numberOfClusters,
            Distance distance,
            int limitNumberOfIterations
    ) {
        return null;
    }

    private static void applyPreconditions() {}

    private static void assignToCluster() {}

    private static Centroid nearestCentroid() {
        return null;
    }

    private static Centroid average(
            Centroid centroid,
            List<Record> records
    ) {
        return null;
    }

    private static List<Centroid> relocateCentroids(
            Map<Centroid, List<Record>> clusters
    ) {
        return null;
    }
}
