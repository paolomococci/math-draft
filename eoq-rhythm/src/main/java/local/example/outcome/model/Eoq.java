package local.example.outcome.model;

public class Eoq {

    public double demand;
    public double costOfIssuing;
    public double price;
    public double interestRate;
    public double costOfStock;
    public double demandRate;
    public double productionRate;
    public long quantity;
    public long ordersToProcess;

    public Eoq() {
    }

    public Eoq(
            double demand,
            double costOfIssuing,
            double price,
            double interestRate,
            double costOfStock
    ) {
        this.demand = Math.abs(demand);
        this.costOfIssuing = Math.abs(costOfIssuing);
        this.price = Math.abs(price);
        this.interestRate = Math.abs(interestRate);
        this.costOfStock = Math.abs(costOfStock);
    }
}
