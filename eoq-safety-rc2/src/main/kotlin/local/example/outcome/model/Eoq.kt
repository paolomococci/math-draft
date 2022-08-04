package local.example.outcome.model

import java.util.concurrent.atomic.AtomicLong
import kotlin.math.roundToLong
import kotlin.math.sqrt

class Eoq() {

    private val atomicLong = AtomicLong()

    var id: String? = null
    var demand = 0.0
    var sigmaDemand = 0.0
    var procurementLeadTime = 0.0
    var sigmaProcurementLeadTime = 0.0
    var serviceLevelKey = 0.0
    var costOfIssuing = 0.0
    var price = 0.0
    var interestRate = 0.0
    var costOfStock = 0.0
    var quantity: Long = 0L
    var ordersToProcess: Long = 0L
    var safetyStock: Long = 0L
    var cycleStock: Long = 0L
    var reorderLevel: Long = 0L

    constructor(
        id: String,
        demand: Double,
        sigmaDemand: Double,
        procurementLeadTime: Double,
        sigmaProcurementLeadTime: Double,
        serviceLevelKey: Double,
        costOfIssuing: Double,
        price: Double,
        interestRate: Double,
        costOfStock: Double,
        quantity: Long,
        ordersToProcess: Long,
        safetyStock: Long,
        cycleStock: Long,
        reorderLevel: Long
    ): this() {
        this.id = id
        this.demand = demand
        this.sigmaDemand = sigmaDemand
        this.procurementLeadTime = procurementLeadTime
        this.sigmaProcurementLeadTime = sigmaProcurementLeadTime
        this.serviceLevelKey = serviceLevelKey
        this.costOfIssuing = costOfIssuing
        this.price = price
        this.interestRate = interestRate
        this.costOfStock = costOfStock
        this.quantity = quantity
        this.ordersToProcess = ordersToProcess
        this.safetyStock = safetyStock
        this.cycleStock = cycleStock
        this.reorderLevel = reorderLevel
    }

    fun setEoq() {
        this.id = this.generateID()
        val averageDemandExpressedInPiecesPerDay: Double = this.demand / 365
        this.quantity = this.economicOrderQuantity(
            demand,
            costOfIssuing,
            price,
            interestRate,
            costOfStock
        )
        this.ordersToProcess = this.numberOfOrdersToProcess(
            demand,
            quantity
        )
        this.safetyStock = this.computeSafetyStock(
            this.serviceLevelKey,
            this.sigmaDemand,
            this.procurementLeadTime
        )
        this.reorderLevel = this.computeReorderLevel(
            averageDemandExpressedInPiecesPerDay,
            this.procurementLeadTime,
            this.safetyStock
        )
    }

    private fun economicOrderQuantity(
        demand: Double,
        costOfIssuing: Double,
        price: Double,
        interestRate: Double,
        costOfStock: Double
    ): Long {
        val epsilon = 0.000001
        return if (price.compareTo(0.0) < epsilon || interestRate.compareTo(0.0) < epsilon
        ) 0L else sqrt(
            2 * costOfIssuing * demand / (price * interestRate + 2 * costOfStock)
        ).roundToLong()
    }

    private fun numberOfOrdersToProcess(
        demand: Double,
        quantity: Long
    ): Long {
        return if (this.quantity <= 0L) 0 else (demand / quantity).roundToLong()
    }

    private fun computeCycleStock(
        averageDemandExpressedInPiecesPerDay: Double,
        procurementLeadTime: Double,
    ): Long {
        return ((averageDemandExpressedInPiecesPerDay * procurementLeadTime) / 2).toLong()
    }

    private fun computeSafetyStock(
        serviceLevelKey: Double,
        sigmaDemand: Double,
        procurementLeadTime: Double
    ): Long {
        return (serviceLevelKey * sigmaDemand * sqrt(procurementLeadTime))
            .roundToLong()
    }

    private fun computeReorderLevel(
        averageDemandExpressedInPiecesPerDay: Double,
        procurementLeadTime: Double,
        safetyStock: Long
    ): Long {
        return ((averageDemandExpressedInPiecesPerDay * procurementLeadTime) + safetyStock)
            .roundToLong()
    }

    private fun generateID(): String {
        return this.atomicLong.getAndIncrement().toString()
    }
}
