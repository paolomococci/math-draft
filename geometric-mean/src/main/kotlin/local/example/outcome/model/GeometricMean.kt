package local.example.outcome.model

class GeometricMean() {

    var values: Array<Double> = emptyArray()
    var geoMu: Double = 0.0

    constructor(values: Array<Double>) : this() {
        this.values = values.copyOf()
    }
}