package local.example.outcome.model;

public class Eoq {

    public double demand;
    public double costOfIssuing;
    public double price;
    public double interestRate;
    public double costOfStock;
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

    public void setEoq() {
        this.quantity = this.economicOrderQuantity(
                this.demand,
                this.costOfIssuing,
                this.price,
                this.interestRate,
                this.costOfStock
        );
        this.ordersToProcess = this.numberOfOrdersToProcess(
                this.demand,
                this.quantity
        );
    }

    private long economicOrderQuantity(
            double demand,
            double costOfIssuing,
            double price,
            double interestRate,
            double costOfStock
    ) {
        double epsilon = 0.000001D;
        if (Double.compare(price, 0.0) < epsilon || Double.compare(interestRate, 0.0) < epsilon)
            return 0L;
        return Math.round(Math.sqrt((2 * costOfIssuing * demand) / (price * interestRate + 2 * costOfStock)));
    }

    private long numberOfOrdersToProcess(
            double demand,
            long quantity
    ) {
        if (this.quantity <= 0L)
            return 0;
        return Math.round(demand / quantity);
    }
}
