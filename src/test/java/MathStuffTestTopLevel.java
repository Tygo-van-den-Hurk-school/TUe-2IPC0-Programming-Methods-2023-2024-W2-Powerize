import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

/**
 * Test cases for top-level methods in {@code MathStuff}.
 *
<!--//# BEGIN TODO: Name, student ID, and date-->
<p><b>Tygo van den Hurk, 1705709, 24-nov-2023</b></p>
<!--//# END TODO-->
 */
public class MathStuffTestTopLevel {

    // Test cases for power(int, int).

    /**
     * Invokes power(a, b) and checks for expected result.
     *
     * @param a         the base
     * @param b         the exponent
     * @param expResult the expected result
     * @pre {@code 0 <= b && expResult = a ^ b}
     */
    private void checkPower(int a, int b, long expResult) {
        System.out.println("power(" + a + ", " + b + ")");
        long result = MathStuff.power(a, b);
        assertEquals(expResult, result, "result");
    }

    /** Smallest exponent. */
    @Test
    public void testPower0() {
        checkPower(0, 0, 1);
    }

    /** Exponent 1. */
    @Test
    public void testPower1() {
        checkPower(2, 1, 2);
    }

    /** Exponent 2. */
    @Test
    public void testPower2() {
        checkPower(3, 2, 9);
    }

    /** Largest base and smallest exponent without overflow. */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPowerSmallestNoOverflow() {
        int n = Integer.MAX_VALUE;
        checkPower(n, 1, n);
    }

    /** Smallest base > 1 and largest exponent without overflow. */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPowerLargestNoOverflow() {
        checkPower(2, 30, Integer.MAX_VALUE / 2 + 1);
    }

    /** Largest base and smallest exponent > 1 with overflow. */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPowerSmallestOverflow() {
        checkPower(46341, 2, Long.MAX_VALUE);
    }

    /** Smallest base > 1 and smallest exponent with overflow. */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPowerLargestOverflow() {
        checkPower(2, 31, Long.MAX_VALUE);
    }

    /**
     * Invokes {@code power(a, b)} and checks for expected exception.
     *
     * @param a        base
     * @param b        exponent
     * @param expected expected exception
     */
    private void checkPowerException(int a, int b, Class<? extends Throwable> expected) {
        System.out.println("power(" + a + ", " + b + "), for exception");
        Throwable actual = assertThrows(expected, () -> MathStuff.power(a, b),
                "should have thrown " + expected);
        assertNotNull(actual.getMessage(), "message should not be null");
    }

    /** Negative base, non-negative exponent. */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPowerExceptionA() {
        checkPowerException(-1, 0, IllegalArgumentException.class);
    }

    /** Negative exponent, non-negative base. */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testPowerExceptionB() {
        checkPowerException(0, -1, IllegalArgumentException.class);
    }

    // Test cases for power(Power)

    /** Smoke test. */
    @Test
    public void testPowerPower() {
        System.out.println("power(new Power(3, 2))");
        MathStuff.Power p = new MathStuff.Power(3, 2);
        assertEquals(3 * 3, MathStuff.power(p), "result");
    }

    // Test cases for powerize(int)

    /**
     * Invokes powerize(power(expB, expE)) and checks for expected result.
     *
     * @param expB expected base
     * @param expE expected exponent
     * @pre {@code expB} is not a power with exponent greater than one, and
     *     {@code powerize(expB ^ expE).pre}
     */
    private void checkPowerize(int expB, int expE) {
        long n = MathStuff.power(expB, expE);
        System.out.println("powerize(" + n + ")");
        MathStuff.Power result = MathStuff.powerize((int) n);
        assertEquals(n, MathStuff.power(result), "power(result)");
        assertAll(
                () -> assertEquals(expB, result.base, "base"),
                () -> assertEquals(expE, result.exponent, "exponent")
        );
    }

    //# BEGIN TODO: Implementations of test cases for powerize(int)

    //# END TODO
}
