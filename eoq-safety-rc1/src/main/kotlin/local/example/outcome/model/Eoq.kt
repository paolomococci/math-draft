package local.example.outcome.model

import java.util.concurrent.atomic.AtomicLong

class Eoq() {

    private val atomicLong = AtomicLong()

    lateinit var id: String
    var demand = 0.0
    var costOfIssuing = 0.0
    var price = 0.0
    var interestRate = 0.0
    var costOfStock = 0.0
    var quantity: Long = 0
    var ordersToProcess: Long = 0

    fun setEoq() {
        TODO("Not yet implemented")
    }

    private fun generateID(): String? {
        return this.atomicLong.getAndIncrement().toString()
    }
}
