package local.example.outcome.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sieve {

    public int top;
    public List<Integer> primes = new ArrayList<>();

    public Sieve() {
    }

    public Sieve(int top) {
        this.top = top;
    }

    public void setPrimes() {
        this.primes = this.sift();
    }

    private List<Integer> sift() {
        int max = this.top;
        List<Integer> primes = new ArrayList<>();
        boolean[] integers = new boolean[max+1];

        Arrays.fill(integers, true);

        for (int external = 2; external*external <= max; external++) {
            if (integers[external]) {
                for (int internal = external*external; internal <= max; internal += external) {
                    integers[internal] = false;
                }
            }
        }

        for (int index = 2; index <= max; index++) {
            if (integers[index]) {
                primes.add(index);
            }
        }
        return primes;
    }
}
