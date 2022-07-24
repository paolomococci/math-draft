package local.example.outcome.model

class Sigma(var values: Array<Double>) {

    var mu: Double = 0.0
    var sigma: Double = 0.0

    init {
        this.mu = this.values.average()
    }
    fun setStandardDeviation() {
        TODO("Not yet implemented")
    }
}
