import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Test suite for MathStuff.
 *
 * @author Tom Verhoeff (TU/e)
 * @since 2022-11-19
 */
@Suite
@SelectClasses({ MathStuffTestTopLevel.class, MathStuffTestAuxiliary.class })
public class MathStuffTest {}
