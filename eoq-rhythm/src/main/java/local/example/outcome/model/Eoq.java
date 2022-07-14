package local.example.outcome.model;

public class Eoq {

    public double demand;
    public double setUpCost;
    public double price;
    public double interestRate;
    public double costOfStock;
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
            double costOfStock,
            double demandRate,
            double productionRate
    ) {
        this.demand = Math.abs(demand);
        this.setUpCost = Math.abs(setUpCost);
        this.price = Math.abs(price);
        this.interestRate = Math.abs(interestRate);
        this.costOfStock = Math.abs(costOfStock);
        this.demandRate = Math.abs(demandRate);
        this.productionRate = Math.abs(productionRate);
    }

    private long economicOrderQuantity() {
        // TODO
        return 0L;
    }

    private long numberOfBatchesToBeProcess() {
        // TODO
        return 0L;
    }
}
