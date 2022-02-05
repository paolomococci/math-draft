package local.example.outcome.model;

import java.util.List;

public class Sieve {

    public long a;
    public List<Boolean> prime;

    public Sieve() {
    }

    public Sieve(long a, List<Boolean> prime) {
        this.a = a;
        this.prime = prime;
    }
}
