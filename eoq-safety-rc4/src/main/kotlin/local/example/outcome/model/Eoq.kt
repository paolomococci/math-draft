package local.example.outcome.model

import java.util.concurrent.atomic.AtomicLong
import kotlin.math.roundToLong
import kotlin.math.sqrt

class Eoq() {

    private val atomicLong = AtomicLong()

    var id: String? = null

    // values provided in input
    var demand = 0.0
    var sigmaDemand = 0.0
    var procurementLeadTime = 0.0
    var sigmaProcurementLeadTime = 0.0
    var serviceLevelKey = 0.0
    var costOfIssuing = 0.0
    var price = 0.0
    var interestRate = 0.0
    var stockRate = 0.0
    var spaceRate = 0.0

    // computed values
    var quantity: Long = 0L
    var ordersToProcess: Long = 0L
    var safetyStock: Long = 0L
    var averageStock: Long = 0
    var cycleStock: Long = 0L
    var reorderLevel: Long = 0L
    var stockMaintenanceCost: Double = 0.0
    var totalCostOfIssuingOrders: Double = 0.0
    var totalCostOfStock: Double = 0.0

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
        stockRate: Double,
        spaceRate: Double,
        quantity: Long,
        ordersToProcess: Long,
        safetyStock: Long,
        cycleStock: Long,
        averageStock: Long,
        reorderLevel: Long,
        stockMaintenanceCost: Double,
        totalCostOfIssuingOrders: Double,
        totalCostOfStock: Double

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
        this.stockRate = stockRate
        this.spaceRate = spaceRate
        this.quantity = quantity
        this.ordersToProcess = ordersToProcess
        this.safetyStock = safetyStock
        this.cycleStock = cycleStock
        this.averageStock = averageStock
        this.reorderLevel = reorderLevel
        this.stockMaintenanceCost = stockMaintenanceCost
        this.totalCostOfIssuingOrders = totalCostOfIssuingOrders
        this.totalCostOfStock = totalCostOfStock
    }

    fun setEoq() {
        this.id = this.generateID()
        val dailyDemand: Double = this.demand / 220
        this.quantity = this.computeEconomicOrderQuantity(
            this.demand,
            this.costOfIssuing,
            this.price,
            this.interestRate,
            this.stockRate,
            this.spaceRate
        )
        this.ordersToProcess = this.computeOrdersToProcess(
            demand,
            quantity
        )
        this.safetyStock = this.computeSafetyStock(
            this.procurementLeadTime,
            this.sigmaDemand,
            this.sigmaProcurementLeadTime,
            dailyDemand,
            serviceLevelKey
        )
        this.cycleStock = (this.quantity / 2.0).roundToLong()
        this.averageStock = (this.cycleStock + this.safetyStock)
        this.reorderLevel = this.computeReorderLevel(
            dailyDemand,
            this.procurementLeadTime,
            this.safetyStock
        )
        this.stockMaintenanceCost = this.computeStockMaintenanceCost(
            this.quantity,
            this.safetyStock,
            this.price,
            this.interestRate,
            this.stockRate,
            this.spaceRate
        )
        this.totalCostOfIssuingOrders = this.computeTotalCostOfIssuingOrders(
            this.costOfIssuing,
            this.ordersToProcess
        )
        this.totalCostOfStock = this.computeTotalCostOfStock(
            this.stockMaintenanceCost,
            this.totalCostOfIssuingOrders
        )
    }

    private fun computeEconomicOrderQuantity(
        demand: Double,
        costOfIssuing: Double,
        price: Double,
        interestRate: Double,
        stockRate: Double,
        spaceRate: Double
    ): Long {
        val epsilon = 0.000001
        return if (price.compareTo(0.0) < epsilon || interestRate.compareTo(0.0) < epsilon
        ) 0L else sqrt(
            2 * costOfIssuing * demand / (price * (interestRate + stockRate + spaceRate))
        ).roundToLong()
    }

    private fun computeOrdersToProcess(
        demand: Double,
        quantity: Long
    ): Long {
        return if (this.quantity <= 0L) 0 else (demand / quantity).roundToLong()
    }

    private fun computeSigma(
        procurementLeadTime: Double,
        sigmaDemand: Double,
        sigmaProcurementLeadTime: Double,
        dailyDemand: Double
    ): Long {
        return sqrt(
            (procurementLeadTime * sigmaDemand * sigmaDemand) +
                    (sigmaProcurementLeadTime * dailyDemand * dailyDemand)
        ).roundToLong()
    }

    private fun computeSafetyStock(
        procurementLeadTime: Double,
        sigmaDemand: Double,
        sigmaProcurementLeadTime: Double,
        dailyDemand: Double,
        serviceLevelKey: Double
    ): Long {
        return (
                this.computeSigma(
                    procurementLeadTime,
                    sigmaDemand,
                    sigmaProcurementLeadTime,
                    dailyDemand
                ) * serviceLevelKey)
            .roundToLong()
    }

    private fun computeReorderLevel(
        dailyDemand: Double,
        procurementLeadTime: Double,
        safetyStock: Long
    ): Long {
        return ((dailyDemand * procurementLeadTime) + safetyStock).roundToLong()
    }

    private fun computeStockMaintenanceCost(
        quantity: Long,
        safetyStock: Long,
        price: Double,
        interestRate: Double,
        stockRate: Double,
        spaceRate: Double
    ): Double {
        return ((quantity / 2.0) + safetyStock) * price * (interestRate + stockRate + spaceRate)
    }

    private fun computeTotalCostOfIssuingOrders(
        costOfIssuing: Double,
        ordersToProcess: Long
    ): Double {
        return costOfIssuing * ordersToProcess
    }

    private fun computeTotalCostOfStock(
        stockMaintenanceCost: Double,
        totalCostOfIssuingOrders: Double
    ): Double {
        return stockMaintenanceCost + totalCostOfIssuingOrders
    }

    private fun generateID(): String {
        return this.atomicLong.getAndIncrement().toString()
    }
}
