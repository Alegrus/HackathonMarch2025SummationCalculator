package calculator;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Summation base class
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class SummationTest {
    // Testing class initializing to correct basic values
    @Test
    public void createSummation() {
        Summation s1 = new Summation("1", "2", "3");
        assertEquals("1", s1.getFrom());
        assertEquals("2", s1.getTo());
        assertEquals("3", s1.getVal());
        assertNull(s1.getFromPolish());
        assertNull(s1.getToPolish());
        assertNull(s1.getValPolish());
    }

    // Testing polish notation val variable initializing to correct value
    @Test
    public void polishValTest() {
        LinkedList<String> val2 = new LinkedList<>();
        val2.add("x");
        val2.add("2");
        val2.add("^");
        Summation s2 = new Summation("4", "5", val2);
        assertEquals("4", s2.getFrom());
        assertEquals("5", s2.getTo());
        assertNull(s2.getVal());
        assertNull(s2.getFromPolish());
        assertNull(s2.getToPolish());
        assertEquals(val2, s2.getValPolish());

        // Checks if the polish val references the same object (it should not)
        assertNotSame(val2, s2.getValPolish());
    }

    // Testing all polish notation variables initializing to correct values
    @Test
    public void polishVariablesTest() {
        LinkedList<String> from3 = new LinkedList<>();
        from3.add("n");
        LinkedList<String> to3 = new LinkedList<>();
        to3.add("3");
        to3.add("n");
        to3.add("*");
        to3.add("1");
        to3.add("+");
        LinkedList<String> val3 = new LinkedList<>();
        val3.add("x");
        val3.add("2");
        val3.add("^");
        Summation s3 = new Summation(from3, to3, val3);
        assertNull(s3.getFrom());
        assertNull(s3.getTo());
        assertNull(s3.getVal());
        assertEquals(from3, s3.getFromPolish());
        assertEquals(to3, s3.getToPolish());
        assertEquals(val3, s3.getValPolish());

        // Checks if the polish values reference their input object (it should not)
        assertNotSame(from3, s3.getFromPolish());
        assertNotSame(to3, s3.getToPolish());
        assertNotSame(val3, s3.getValPolish());
    }
}
