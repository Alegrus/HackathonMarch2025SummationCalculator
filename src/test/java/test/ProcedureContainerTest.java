package test;

import main.ProcedureContainer;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Complex Sum class
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class ProcedureContainerTest {

    public static int test;

    // Tests the creation of the container class
    @Test
    public void creationTest() {
        test = 0;
        ProcedureContainer pc = new ProcedureContainer(
                2, "Test description", ProcedureContainerTest::testerRunnable);
        pc.procedure().run();
        assertEquals(2, pc.choice());
        assertEquals("Test description", pc.description());
        // Checks if the method was stored and run properly
        assertEquals(-25, test);
    }

    // Small helper method to act as a Runnable
    private static void testerRunnable() {
        test = -25;
    }
}
