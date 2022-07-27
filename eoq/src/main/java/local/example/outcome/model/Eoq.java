package local.example.outcome.model;

import java.util.concurrent.atomic.AtomicLong;

public class Eoq {

    private static final AtomicLong ATOMIC_LONG = new AtomicLong();

    public String id;
    public double demand;
    public double costOfIssuing;
    public double price;
    public double interestRate;
    public long quantity;
    public long ordersToProcess;

    public Eoq() {
    }

    public Eoq(
            double demand,
            double costOfIssuing,
            double price,
            double interestRate
    ) {
        this.demand = Math.abs(demand);
        this.costOfIssuing = Math.abs(costOfIssuing);
        this.price = Math.abs(price);
        this.interestRate = Math.abs(interestRate);
    }

    public void setEoq() {
        this.id = this.generateID();
        this.quantity = this.economicOrderQuantity(
                this.demand,
                this.costOfIssuing,
                this.price,
                this.interestRate
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
            double interestRate
    ) {
        double epsilon = 0.000001D;
        if (Double.compare(price, 0.0) < epsilon || Double.compare(interestRate, 0.0) < epsilon)
            return 0L;
        return Math.round(Math.sqrt((2 * costOfIssuing * demand) / (price * interestRate)));
    }

    private long numberOfOrdersToProcess(
            double demand,
            long quantity
    ) {
        if (this.quantity <= 0L)
            return 0;
        return Math.round(demand / quantity);
    }

    private String generateID() {
        return String.valueOf(ATOMIC_LONG.getAndIncrement());
    }
}
