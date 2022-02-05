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

    public void setLcm() {
        this.lcm = this.leastCommonMultiple(this.a, this.b);
    }

    private int leastCommonMultiple(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }

        int higher = Math.max(a, b);
        int lower = Math.min(a, b);
        int lcm = higher;
        while (lcm % lower != 0) {
            lcm += higher;
        }
        return lcm;
    }
}
