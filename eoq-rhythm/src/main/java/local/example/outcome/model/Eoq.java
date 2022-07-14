package local.example.outcome.model;

public class Eoq {

    public double demand;
    public double setUpCost;
    public double interestRate;
    public double stockCost;
    public double productionCost;
    public double demandRate;
    public double productionRate;
    public long quantity;
    public double leadTimeInMinutes;
    public long batchesToProcess;

    public Eoq() {
    }

    public Eoq(
            double demand,
            double setUpCost,
            double price,
            double interestRate,
            double stockCost,
            double productionCost,
            double demandRate,
            double productionRate
    ) {
        this.demand = Math.abs(demand);
        this.setUpCost = Math.abs(setUpCost);
        this.interestRate = Math.abs(interestRate);
        this.stockCost = Math.abs(stockCost);
        this.productionCost = Math.abs(productionCost);
        this.demandRate = Math.abs(demandRate);
        this.productionRate = Math.abs(productionRate);
    }

    public void setEoq() {
        // TODO
    }

    private long economicOrderQuantity(
            double demand,
            double setUpCost,
            double interestRate,
            double stockCost,
            double productionCost,
            double demandRate,
            double productionRate
    ) {
        double epsilon = 0.000001D;
        if (Double.compare((productionCost * interestRate + 2 * stockCost), 0.0) < epsilon || Double.compare(interestRate, 0.0) < epsilon)
            return 0L;
        return Math.round(
                Math.sqrt(
                        (2 * setUpCost * demand) / (
                                (productionCost * interestRate + 2 * stockCost) * (1 - demandRate / productionRate)
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

    private double leadTimeInMinutes() {
        // TODO
        return 0.0;
    }
}
