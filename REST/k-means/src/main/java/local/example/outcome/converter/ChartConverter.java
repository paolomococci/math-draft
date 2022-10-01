package local.example.outcome.converter;

import local.example.outcome.model.Centroid;
import local.example.outcome.model.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChartConverter {

    private static Map<String, Objects> chartConverter(
            Map<Centroid, List<Record>> clusters
    ) {
        Map<String, Object> json = new HashMap<>();
        return null;
    }
}
