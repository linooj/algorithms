package ee.ttu.algoritmid.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class AL01B {

    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     * @param n The n-th number to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public String timeToComputeRecursiveFibonacci(int n) {
        long start1 = System.nanoTime();
        BigInteger lines = recursiveF(40).multiply(BigInteger.valueOf(3)).subtract(BigInteger.TWO);
        long end1 = System.nanoTime();
        long forty = end1 - start1;

        double golden = 1.618;
        double power = 0;
        if (n > 40) {
            power = Math.pow(golden, n-40);
        } else {
            power = 1 / Math.pow(golden, 40-n);
            //power = BigDecimal.ONE.divide(BigDecimal.valueOf(golden).pow(40- n), RoundingMode.HALF_EVEN);
        }

        double n_time = forty * power;
        //BigDecimal n_lines = BigDecimal.valueOf(forty).multiply(power);
        double aa = 3.1557;
        //long ee = (long) aa;
        double time = n_time / Math.pow(aa, 16);
        //BigDecimal time = n_lines.divide(BigDecimal.valueOf(ee).pow(16), 10);
        return String.valueOf(time);
    }

    /**
     * Compute the Fibonacci sequence number recursively.
     * (You need this in the timeToComputeRecursiveFibonacci(int n) function!)
     * @param n The n-th number to compute.
     * @return The n-th Fibonacci number as a string.
     */
    public BigInteger recursiveF(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);
        return recursiveF(n - 1).add(recursiveF(n - 2));
    }

    public static void main(String[] args) {
        AL01B test = new AL01B();
        long start1 = System.nanoTime();
        BigInteger lines = test.recursiveF(40).multiply(BigInteger.valueOf(3)).subtract(BigInteger.TWO);
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
}


