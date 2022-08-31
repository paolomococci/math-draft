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
            this.harmonic(
                this.values.size,
                this.summation(this.values)
            ),
            2
        )
    }

    private fun harmonic(num: Int, sum: Double): Double {
        return num / sum
    }

    private fun summation(values: Array<Double>): Double {
        var addends = 0.0
        for (addend in values)
            addends += (1 / addend)
        return addends
    }

    private fun roundOff(value: Double, placeTo: Int): Double {
        var place = 1.0
        for (i in 1..placeTo)
            place *= 10.0
        return ((value * place).roundToLong() / place)
    }
}