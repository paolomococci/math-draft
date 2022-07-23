package local.example.outcome.model

class Average() {

    var values: Array<Double> = emptyArray()
    var mu: Double = 0.0

    constructor(values: Array<Double>) : this() {
        this.values = values.copyOf()
        this.mu = values.average()
    }
}