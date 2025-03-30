package test;

import main.ComplexSum;
import org.junit.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Complex Sum class
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class ComplexSumTest {
    // Testing simple values
    @Test
    public void complexTestSimpleValues() {
        LinkedList<String> val1 = new LinkedList<>();
        val1.add("x");
        ComplexSum cs1 = new ComplexSum("1", "5", val1);
        assertTrue(cs1.calculate().contains("15"));
    }

    // Testing more complex values
    @Test
    public void complexTestComplexValues() {
        LinkedList<String> val2 = new LinkedList<>();
        val2.add("x");
        val2.add("2");
        val2.add("^");
        val2.add("3");
        val2.add("+");
        ComplexSum cs2 = new ComplexSum("1", "5", val2);
        assertTrue(cs2.calculate().contains("70"));
    }

    // Testing error reporting and returning null
    @Test
    public void errorTest() {
        LinkedList<String> val3 = new LinkedList<>();
        val3.add("1");
        val3.add("x");
        val3.add("/");
        ComplexSum cs3 = new ComplexSum("0", "5", val3);
        assertNull(cs3.calculate());
    }
}
