package local.example.outcome.model

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

    private fun sumOfSquares(): Double {
        return TODO("Provide the return value")
    }

    private fun producedInverseOfNum(): Double {
        return TODO("Provide the return value")
    }
}
