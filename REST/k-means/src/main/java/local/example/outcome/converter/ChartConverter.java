package local.example.outcome.converter;

import local.example.outcome.model.Centroid;
import local.example.outcome.model.Record;

import java.util.*;
import java.util.stream.Collectors;

public class ChartConverter {

    private static Map<String, Object> dataToChartConverter(
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
        return json;
    }

    private static String dominantFeature(Centroid centroid) {
        return centroid.coordinates.keySet()
                .stream().limit(2).collect(
                        Collectors.joining(", ")
                );
    }

    private static Centroid sortedCentroid(Centroid centroid) {
        // TODO: 01/10/22  
        return centroid;
    }
}
