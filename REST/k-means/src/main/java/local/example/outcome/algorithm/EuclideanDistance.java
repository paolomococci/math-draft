package local.example.outcome.algorithm;

import local.example.outcome.model.Distance;

import java.util.Map;

public class EuclideanDistance implements Distance {

    @Override
    public double compute(
            Map<String, Double> featuresOne,
            Map<String, Double> featuresTwo
    ) {
        double amount = 0.0;

        for (String key : featuresOne.keySet()) {
            Double f1 = featuresOne.get(key);
            Double f2 = featuresTwo.get(key);

            if (f1 != null && f2 != null)
                amount += Math.pow(f1 - f2, 2);
        }
        return 0;
    }
}
