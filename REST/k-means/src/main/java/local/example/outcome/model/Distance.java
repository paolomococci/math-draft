package local.example.outcome.model;

import java.util.Map;

public interface Distance {

    double compute(
            Map<String, Double> featuresOne,
            Map<String, Double> featuresTwo
    );
}
