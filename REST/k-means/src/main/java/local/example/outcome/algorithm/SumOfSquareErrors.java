package local.example.outcome.algorithm;

import local.example.outcome.model.Centroid;
import local.example.outcome.model.Distance;
import local.example.outcome.model.Record;

import java.util.List;
import java.util.Map;

public class SumOfSquareErrors {

    public static double sumSquareErrors(
            Map<Centroid, List<Record>> clusters,
            Distance distance
    ) {
        double sum = 0.0;
        for (Map.Entry<Centroid, List<Record>> entry : clusters.entrySet()) {
            Centroid centroid = entry.getKey();
            for (Record record : entry.getValue()) {
                double value = distance.compute(
                        centroid.coordinates,
                        record.features
                );
                sum += Math.pow(value, 2);
            }
        }
        return 0;
    }
}
