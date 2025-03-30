package calculator;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Basic Sum class
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class BasicSumTest {
    // Basic test for calculation
    @Test
    public void basicTest() {
        BasicSum bs = new BasicSum("1", "3", "5");
        assertEquals("15", bs.calculate());
    }

    // Test for handling negative values
    @Test
    public void negativeTest() {
        BasicSum bs2 = new BasicSum("0", "3", "-1");
        assertEquals("-4", bs2.calculate());
    }

    // Test to give 0 when sum not counted
    @Test
    public void noSummation() {
        BasicSum bs3 = new BasicSum("3", "1", "6");
        assertEquals("0", bs3.calculate());
    }
}
