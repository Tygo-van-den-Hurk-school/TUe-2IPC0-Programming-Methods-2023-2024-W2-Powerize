import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Test cases for auxiliary methods in {@code MathStuff}.
 *
<!--//# BEGIN TODO: Name, student ID, and date-->
<p><b>Tygo van den Hurk, 1705709, 24-nov-2023</b></p>
<!--//# END TODO-->
 */
public class MathStuffTestAuxiliary {

    //# BEGIN TODO: Test cases for auxiliary functions
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Greatest Common Devisor ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    /**
     * Invokes {@code Mathstuff.gcd(a, b)} and checks for expected result.
     *
     * @param a         the first number to get the greatest common devisor of.
     * @param b         the second number to get the greatest common devisor of.
     * @param expResult the expected greatest common devisor of {@code a}, and {@code b}.
     * @pre {@code
     *   0 <= a
     *   && 0 <= b
     *   && \forall(
     *     devisor; 
     *     (a % devisor == 0 && b % devisor == 0);
     *     devisor <= expResult
     *   )
     * }
     */
    private void checkGCD(final int a, final int b, final int expResult) {
        System.out.println("gcd(" + a + ", " + b + ")");
        assertEquals(expResult, MathStuff.gcd(a, b), "gcd(result)");
    }

    @Test
    public void testGCD0() {
        checkGCD(4, 8, 4);
    }

    @Test
    public void testGCD1() {
        checkGCD(32, 8, 8);
    }

    @Test
    public void testGCD2() {
        checkGCD(45, 1, 1);
    }

    // /** // since the function does not need to be robust, this won't be needed.
    //  * Invokes {@code Mathstuff.gcd(n)} and checks for expected exception.
    //  *
    //  * @param a         the first number to get the greatest common devisor of.
    //  * @param b         the second number to get the greatest common devisor of.
    //  * @param expected expected exception
    //  */
    // private void checkGCDException(final int a, final int b, 
    //     final Class<? extends Throwable> expected) {
    // 
    //     System.out.println("gcd(" + a + ", " + b + "), for exception");
    //     Throwable actual = assertThrows(expected, () -> MathStuff.gcd(a, b),
    //             "should have thrown " + expected);
    //     assertNotNull(actual.getMessage(), "message should not be null");
    // }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    //# END TODO

}
