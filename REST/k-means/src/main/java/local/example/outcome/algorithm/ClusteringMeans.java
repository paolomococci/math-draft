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
        // TODO: 27/09/22
        return null;
    }

    private static void applyPreconditions(
            List<Record> records,
            int numberOfClusters,
            Distance distance,
            int limitNumberOfIterations
    ) {
        if (records == null || records.isEmpty())
            throw new IllegalArgumentException("the record list can't be empty");
    }

    private static void assignToCluster(
            Map<Centroid, List<Record>> clusters,
            Record record,
            Centroid centroid
    ) {
        // TODO: 27/09/22
    }

    private static Centroid nearestCentroid(
            Record record,
            List<Centroid> centroids,
            Distance distance
    ) {
        // TODO: 27/09/22
        return null;
    }

    private static Centroid average(
            Centroid centroid,
            List<Record> records
    ) {
        // TODO: 27/09/22
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
        // TODO: 27/09/22
        return null;
    }
}
