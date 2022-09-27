package local.example.outcome.model;

import java.util.Map;

public class Record {

    public String description;
    public Map<String, Double> features;

    public Record() {
    }

    public Record(String description) {
        this.description = description;
    }

    public Record(
            String description,
            Map<String, Double> features
    ) {
        this.description = description;
        this.features = features;
    }

    public Record(Map<String, Double> features) {
        this.description = "";
        this.features = features;
    }

    @Override
    public String toString() {
        return "Record{" +
                "description='" + description + '\'' +
                ", features=" + features +
                '}';
    }
}
