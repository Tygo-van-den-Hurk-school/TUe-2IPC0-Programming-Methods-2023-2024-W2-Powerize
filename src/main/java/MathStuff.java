import java.util.*;

/**
 * Library with static mathematical functions.
 *
<!--//# BEGIN TODO: Name, student ID, and date-->
<p><b>Replace this line</b></p>
<!--//# END TODO-->
 */
public abstract class MathStuff {

    /**
     * Returns exponentiation, taking care of overflow.
     *
     * @param a the base
     * @param b the exponent
     * @pre {@code 0 <= a && 0 <= b}
     * @return {@code a ^ b} if {@code a ^ b <= Integer.MAX_VALUE}
     *     else {@code Long.MAX_VALUE}
     * @throws IllegalArgumentException if precondition violated
     */
    public static long power(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("power: negative argument");
        }
        // 0 <= a && 0 <= b
        long x = a; // see invariant
        int k = b; // see invariant
        long result = 1L; // see invariant

        // invariant: 0 <= k <= b && result * x^k == a^b
        while (k != 0) {
            if (k % 2 == 0) { // even exponent
                if (x <= Integer.MAX_VALUE) {
                    x *= x;
                } else {
                    x = Long.MAX_VALUE;
                }
                k /= 2;
            } else { // odd exponent
                if (result <= Integer.MAX_VALUE && x <= Integer.MAX_VALUE) {
                    result *= x;
                } else {
                    result = Long.MAX_VALUE;
                }
                k -= 1;
            }
            // invariant holds again, k has decreased
        }
        // k == 0, hence result == a^b

        if (result > Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return result;
    }

    /**
     * Record containing a base and an exponent.
     *
     * @inv {@code 0 <= base && 0 <= exponent}
     */
    public static class Power { // BEGIN RECORD TYPE

        /** The base. */
        public int base;

        /** The exponent. */
        public int exponent;

        /**
         * Constructs a Power with given base and exponent.
         *
         * @param base     the base
         * @param exponent the exponent
         * @pre {@code 0 <= base && 0 <= exponent}
         * @post {@code \result.base == base && \result.exponent == exponent}
         */
        public Power(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

    } // END RECORD TYPE

    /**
     * Returns exponentiation.
     *
     * @param p the base and exponent
     * @pre {@code p != null}
     * @return {@code power(p.base, p.exponent)}
     * @throws IllegalArgumentException if precondition violated
     */
    public static long power(Power p) throws IllegalArgumentException {
        return power(p.base, p.exponent);
    }

    /**
     * Writes a number as a power with maximal exponent.
     *
     * @param n the number to 'powerize'
     * @pre {@code 2 <= n}
     * @post {@code n == power(\result) &&
     *     (\forall int b, int e;
     *      2 <= b && 1 <= e && n == b ^ e;
     *      e <= \result.exponent)}
     * @return power decomposition of {@code n} with maximal exponent
     * @throws IllegalArgumentException if precondition violated
     */
    public static Power powerize(int n) throws IllegalArgumentException {
        //# BEGIN TODO: Implementation of powerize
        
        if (n < 2) {
            throw new IllegalArgumentException("n must be greater then 1.");
        }

        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        /* getting the prime factors and their frequency of n */ {
            final List<Integer> primeFactors = MathStuff.factorize(n);
            for (int number : primeFactors) {
                frequencyMap.put(
                    number, 
                    frequencyMap.getOrDefault(number, 0) + 1
                );
            }
        }

        int exponent;
        /* calculating the exponent from the gcd of the frequency of each prime number of n */ {
            final Collection<Integer> values = frequencyMap.values();
            exponent = MathStuff.getFirstValue(values);
            for (int value : values) {
                exponent = gcd(exponent, value);
            }
        }

        int base = 1;
        /* calculating the base from all the prime factors of n and their respective exponents */ {
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                base *= MathStuff.power(entry.getKey(), (entry.getValue() / exponent));
            }
        }

        return new Power(base, exponent);
        //# END TODO
    }

    //# BEGIN TODO: Contracts and implementations of auxiliary functions

    private static final int getFirstValue(final Collection<Integer> values) {
        for (int value : values) {
            if (value != 0) {
                return value;
            }
        }
        throw new IllegalArgumentException("no first value");
    }

    /** Factorizes a number {@code n} into its prime factors. */
    public static List<Integer> factorize(int n) {
        final List<Integer> factors = new ArrayList<>();
        int divisor = 2;

        while (n > 1) {
            while (n % divisor == 0) {
                factors.add(divisor);
                n /= divisor;
            }
            divisor++;
        }

        return factors;
    }

    /**
     * Returns the greatest common devisor of {@code IntegerA}, and {@code IntegerB}.
     * @param a the first integer to get the greatest common devisor of.
     * @param b the second integer to get the greatest common devisor of.
     * @pre {@code a > 0 && b > 0}
     * @return the greatest common devisor (aka. gcd) of {@code IntegerA}, and {@code IntegerB}.
     * @post {@code 
     *   \return == greatestCommonDevisor
     *   && \forall(
     *     devisor; 
     *     (a % devisor == 0 && b % devisor == 0);
     *     devisor <= greatestCommonDevisor
     *   )
     * }
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            final int temp = b;
            b = (a % b);
            a = temp;
        }

        return a;
    }

    //# END TODO

}
