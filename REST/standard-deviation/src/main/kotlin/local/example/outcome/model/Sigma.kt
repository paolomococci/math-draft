package local.example.outcome.model

import kotlin.math.sqrt

class Sigma() {

    var values: Array<Double> = emptyArray()
    var mu: Double = 0.0
    var sigma: Double = 0.0

    constructor(values: Array<Double>) : this() {
        this.values = values.copyOf()
    }
    fun setStandardDeviation() {
        var sum = 0.0
        this.mu = this.values.average()
        for (value in this.values) sum += square(value - this.mu)
        this.sigma = sqrt(sum / this.values.size)
    }

    private fun square(difference: Double): Double {
        return difference * difference
    }
}
