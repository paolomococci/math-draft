package local.example.outcome.model

class HarmonicMean() {

    var values: Array<Double> = emptyArray()
    var harmonicMu: Double = 0.0

    constructor(
        values: Array<Double>,
        harmonicMu: Double = 0.0
    ) : this() {
        this.values = values.copyOf()
        this.harmonicMu = harmonicMu
    }
}