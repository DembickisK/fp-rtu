package imperative;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

    public enum STATE {
        ABUNDANT,
        PERFECT,
        DEFICIENT
    }

    public static STATE process(int n) {
        int sum = IntStream
                .range(1, n)
                .filter(i -> n % i == 0)
                .sum();
        return sum == n ? STATE.PERFECT : sum > n ? STATE.ABUNDANT : STATE.DEFICIENT;
    }

    public static Set<Integer> divisors(int n) {
        return IntStream
                .range(1, (int)Math.sqrt(n))
                .filter(i -> n % i == 0)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
    }
}
