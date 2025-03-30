package calculator;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Basic Sum class
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class InputParserTest {
    public InputParser ip = new InputParser();

    // Testing parsing of a simple expression
    @Test
    public void simpleParsingTest() {
        Queue<String> result1 = ip.parse("x^2");
        LinkedList<String> test1 = new LinkedList<>();
        test1.add("x");
        test1.add("2");
        test1.add("^");
        assertEquals(test1, result1);
    }

    // Testing parsing of a complex expression
    @Test
    public void complexParsingTest() {
        Queue<String> result2 = ip.parse("(x^2)/(3.5*x)-3");
        LinkedList<String> test2 = new LinkedList<>();
        test2.add("x");
        test2.add("2");
        test2.add("^");
        test2.add("3.5");
        test2.add("x");
        test2.add("*");
        test2.add("/");
        test2.add("3");
        test2.add("-");
        assertEquals(test2, result2);
    }

    // Testing formatting
    @Test
    public void formattingTest() {
        Queue<String> result3 = ip.parse("x (2) +  1");
        LinkedList<String> test3 = new LinkedList<>();
        test3.add("x");
        test3.add("2");
        test3.add("*");
        test3.add("1");
        test3.add("+");
        assertEquals(test3, result3);
    }

    // Testing parentheses mismatch error
    @Test
    public void parenthesesMismatchTest() {
        assertThrows(IllegalArgumentException.class, () -> ip.parse("x)/2"));
        assertThrows(IllegalArgumentException.class, () -> ip.parse("x(/2"));
    }
}
