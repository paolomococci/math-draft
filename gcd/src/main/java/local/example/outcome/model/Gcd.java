package local.example.outcome.model;

public class Gcd {

    public int a;
    public int b;
    public int gcd;

    public Gcd() {
    }

    public Gcd(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setGcd() {
        this.gcd = this.greatestCommonDivisor(this.a, this.b);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        int temp = a % b;
        return greatestCommonDivisor(b, temp);
    }
}
