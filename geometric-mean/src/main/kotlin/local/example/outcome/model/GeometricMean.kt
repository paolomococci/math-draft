package local.example.outcome.model

import kotlin.math.*

class GeometricMean() {

    var values: Array<Double> = emptyArray()
    var geoMu: Double = 0.0

    constructor(values: Array<Double>) : this() {
        this.values = values.copyOf()
    }

    fun setGeoMu() {
        this.geoMu = this.roundOff(
            this.nthRoot(
                this.product(this.values),
                this.values.size
            ),
            5
        )
    }

    private fun product(values: Array<Double>): Double {
        var factors = 1.0
        for (temp in values) {
            factors *= abs(temp)
        }
        return factors
    }

    private fun nthRoot(r: Double, n: Int): Double {
        return Math.E.pow(ln(r) / n)
    }

    private fun roundOff(value: Double, placeTo: Int): Double {
        var place = 10.0
        for (i in 1..placeTo)
            place *= 10.0
        return ((value * place).roundToLong() / place)
    }
}
