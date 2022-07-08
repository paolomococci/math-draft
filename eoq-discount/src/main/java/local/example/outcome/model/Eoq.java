package local.example.outcome.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Eoq {

    public double demand;
    public double costOfIssuing;
    public double price;
    public double[] discounts;
    public long[] minPurchase;
    public double interestRate;
    public double costOfStock;
    public long[] quantity;
    public long[] ordersToProcess;
    public boolean[] validityOfTheMinPurchaseQuantity;

    public Eoq() {
    }

    public Eoq(
            double demand,
            double costOfIssuing,
            double price,
            double[] discounts,
            double interestRate,
            double costOfStock
    ) {
        this.demand = Math.abs(demand);
        this.costOfIssuing = Math.abs(costOfIssuing);
        this.price = Math.abs(price);
        for (int i = 0; i < (this.discounts != null ? this.discounts.length : 0); i++) {
            discounts[i] = Math.abs(this.discounts[i]);
        }
        this.interestRate = Math.abs(interestRate);
        this.costOfStock = Math.abs(costOfStock);
    }

    public void setEoq() {
        this.quantity = this.economicOrderQuantity(
                this.demand,
                this.costOfIssuing,
                this.price,
                this.discounts,
                this.interestRate,
                this.costOfStock
        );
        this.ordersToProcess = this.numberOfOrdersToProcess(
                this.demand,
                this.quantity
        );
    }

    private long[] economicOrderQuantity(
            double demand,
            double costOfIssuing,
            double price,
            double[] discounts,
            double interestRate,
            double costOfStock
    ) {
        long[] quantity = new long[discounts.length];
        double epsilon = 0.000001D;
        if (Double.compare(price, 0.0) < epsilon || Double.compare(interestRate, 0.0) < epsilon) {
            Arrays.fill(quantity, 0L);
            return quantity;
        }
        for (int i = 0; i < discounts.length; i++) {
            quantity[i] = Math.round(
                    Math.sqrt((2 * costOfIssuing * demand) / ((price * (1-discounts[i])) * interestRate + 2 * costOfStock))
            );
        }
        return quantity;
    }

    private long[] numberOfOrdersToProcess(
            double demand,
            long[] quantity
    ) {
        long[] nop = new long[quantity.length];
        for (int i = 0; i < quantity.length; i++) {
            if (quantity[i] <= 0L)
                nop[i] = 0;
            nop[i] = Math.round(demand / quantity[i]);
        }
        return nop;
    }

    private boolean[] validityCheck(
            long[] quantity,
            long[] minPurchase
    ) {
        boolean[] validity = new boolean[0];
        return validity;
    }
}
