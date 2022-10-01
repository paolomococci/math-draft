package local.example.outcome.converter;

import local.example.outcome.model.Centroid;
import local.example.outcome.model.Record;

import java.util.*;

public class ChartConverter {

    private static Map<String, Objects> chartConverter(
            Map<Centroid, List<Record>> clusters
    ) {
        List<Map<String, Object>> children = new ArrayList<>();
        Map<String, Object> json = new HashMap<>();
        clusters.forEach(
                (key, value) -> {
                    Map<String, Object> child = new HashMap<>();
                    child.put(
                            "name",
                            dominantFeature(
                                    sortedCentroid(key)
                            )
                    );
                    List<Map<String, String>> nested = new ArrayList<>();
                    for (Record record : value)
                        nested.add(Collections.singletonMap(
                                "name",
                                record.description
                        ));
                    child.put("children", nested);
                    children.add(child);
                }
        );
        json.put("children", children);
        return null;
    }

    private static String dominantFeature(Centroid centroid) {
        return null;
    }

    private static Centroid sortedCentroid(Centroid centroid) {
        return centroid;
    }
}
