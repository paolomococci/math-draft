package local.example.outcome.model;

public class Lcm {

    public int a;
    public int b;
    public int lcm;

    public Lcm() {
    }

    public Lcm(int a, int b) {
        this.a = Math.abs(a);
        this.b = Math.abs(b);
    }
}
