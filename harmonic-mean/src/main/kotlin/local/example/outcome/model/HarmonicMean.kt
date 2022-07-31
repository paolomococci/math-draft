package local.example.outcome.model

import kotlin.math.roundToLong

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

    fun setHarmonicMu() {
        this.harmonicMu = this.roundOff(
            this.summation(this.values),
            5
        )
    }

    private fun summation(values: Array<Double>): Double {

        return TODO("Provide the return value")
    }

    private fun roundOff(value: Double, placeTo: Int): Double {
        var place = 10.0
        for (i in 1..placeTo)
            place *= 10.0
        return ((value * place).roundToLong() / place)
    }
}