package local.example.outcome.model

import kotlin.math.roundToLong

class RootMeanSquare() {

    var values: Array<Double> = emptyArray()
    var rmsMu: Double = 0.0

    constructor(
        values: Array<Double>,
        rmsMu: Double = 0.0
    ) : this() {
        this.values = values.copyOf()
        this.rmsMu = rmsMu
    }

    private fun sumOfSquares(values: Array<Double>): Double {
        return TODO("Provide the return value")
    }

    private fun producedInverseOfNum(num: Int, sum: Double): Double {
        return TODO("Provide the return value")
    }

    private fun rms(square: Double): Double {
        return TODO("Provide the return value")
    }

    private fun roundOff(value: Double, placeTo: Int): Double {
        var place = 1.0
        for (i in 1..placeTo)
            place *= 10.0
        return ((value * place).roundToLong() / place)
    }
}
