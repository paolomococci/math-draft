package local.example.outcome.model

import kotlin.math.abs

class Eoq {

    var demand = 0.0
    var costOfIssuing = 0.0
    var price = 0.0
    var interestRate = 0.0
    var costOfStock = 0.0
    var quantity: Long = 0
    var ordersToProcess: Long = 0

    fun Eoq() {}

    fun Eoq(
        demand: Double,
        costOfIssuing: Double,
        price: Double,
        interestRate: Double,
        costOfStock: Double
    ) {
        this.demand = abs(demand)
        this.costOfIssuing = abs(costOfIssuing)
        this.price = abs(price)
        this.interestRate = abs(interestRate)
        this.costOfStock = abs(costOfStock)
    }
}