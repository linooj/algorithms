package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

public class AL01A {

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public String iterativeF(int n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        //BigInteger c = new BigInteger();
        if (n == 0) {
            return String.valueOf(a);
        }
        for (int i = 2; i <= n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return String.valueOf(b);
    }
}
