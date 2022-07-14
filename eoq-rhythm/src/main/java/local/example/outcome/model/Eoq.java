package local.example.outcome.model;

public class Eoq {

    private static final double EPSILON = 0.000001D;
    private static final int NUMBER_OF_MINUTES_IN_A_YEAR = 525600;

    public double demand;
    public double setUpCost;
    public double interestRate;
    public double stockCost;
    public double productionCost;
    public double productionRateInMinutes;
    public long quantity;
    public long leadTimeInMinutes;
    public long batchesToProcess;

    public Eoq() {
    }

    public Eoq(
            double demand,
            double setUpCost,
            double interestRate,
            double stockCost,
            double productionCost,
            double productionRateInMinutes
    ) {
        this.demand = Math.abs(demand);
        this.setUpCost = Math.abs(setUpCost);
        this.interestRate = Math.abs(interestRate);
        this.stockCost = Math.abs(stockCost);
        this.productionCost = Math.abs(productionCost);
        this.productionRateInMinutes = Math.abs(productionRateInMinutes);
    }

    public void setEoq() {
        this.quantity = this.economicOrderQuantity(
                this.demand,
                this.setUpCost,
                this.interestRate,
                this.stockCost,
                this.productionCost,
                this.productionRateInMinutes
        );
        this.batchesToProcess = this.numberOfBatchesToBeProcess(
                this.demand,
                this.quantity
        );
        this.leadTimeInMinutes = this.leadTimeInMinutes(
                this.quantity,
                this.productionRateInMinutes
        );
    }

    private long economicOrderQuantity(
            double demand,
            double setUpCost,
            double interestRate,
            double stockCost,
            double productionCost,
            double productionRateInMinutes
    ) {
        if (Double.compare((productionCost * interestRate + 2 * stockCost), 0.0) < EPSILON
                || Double.compare(interestRate, 0.0) < EPSILON)
            return 0L;
        double demandRateInMinutes = demand / NUMBER_OF_MINUTES_IN_A_YEAR;
        return Math.round(
                Math.sqrt(
                        (2 * setUpCost * demand) / (
                                (productionCost * interestRate + 2 * stockCost) *
                                        (1 - demandRateInMinutes / productionRateInMinutes)
                        )
                )
        );
    }

    private long numberOfBatchesToBeProcess(
            double demand,
            long quantity
    ) {
        if (this.quantity <= 0L)
            return 0;
        return Math.round(demand / quantity);
    }

    private long leadTimeInMinutes(
            double quantity,
            double productionRateInMinutes
    ) {
        if (Double.compare(productionRateInMinutes, 0.0) < EPSILON)
            return 0L;
        return Math.round(quantity / productionRateInMinutes);
    }
}
