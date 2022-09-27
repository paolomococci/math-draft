package local.example.outcome.model;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(description, record.description)
                && Objects.equals(features, record.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, features);
    }
}
