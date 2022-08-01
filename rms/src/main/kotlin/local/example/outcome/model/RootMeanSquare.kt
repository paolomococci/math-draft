package local.example.outcome.model

import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.math.sqrt

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

    fun setRmsMu() {
        this.rmsMu = this.roundOff(
            this.rms(
                this.producedInverseOfNum(
                    this.values.size,
                    this.sumOfSquares(
                        this.values
                    )
                )
            ),
            2
        )
    }

    private fun sumOfSquares(values: Array<Double>): Double {
        var sum = 0.0
        for (value in values)
            sum += value.pow(2.0)
        return sum
    }

    private fun producedInverseOfNum(num: Int, sum: Double): Double {
        return sum * (1.0 / num)
    }

    private fun rms(square: Double): Double {
        return sqrt(square)
    }

    private fun roundOff(value: Double, placeTo: Int): Double {
        var place = 1.0
        for (i in 1..placeTo)
            place *= 10.0
        return ((value * place).roundToLong() / place)
    }
}
