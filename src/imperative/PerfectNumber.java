package imperative;


import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {

    public enum STATE {
        ABUNDANT,
        PERFECT,
        DEFICIENT
    }

    public static STATE process(int n) {
        int sum = divisors(n).stream().mapToInt(Integer::intValue).sum() - n;
        return sum == n ? STATE.PERFECT : sum > n ? STATE.ABUNDANT : STATE.DEFICIENT;
    }

    public static Set<Integer> divisors(int n) {
        Set<Integer> divs = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divs.add(i);
            }
        }
        return divs;
    }
}
