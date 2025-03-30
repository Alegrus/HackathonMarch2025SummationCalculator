package test;

import main.Value;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Value base class
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class ValueTest {
    public Value v = new Value("0", "0", "0");

    // Testing simple x^2 evaluation
    @Test
    public void evaluateSimpleNotation() {
        LinkedList<String> pol1 = new LinkedList<>();
        pol1.add("x");
        pol1.add("2");
        pol1.add("^");
        assertEquals(25, v.evaluatePolishNotation(pol1, 5));
    }

    // Testing a complex (x^2+3)/(x-2) evaluation
    @Test
    public void evaluateComplexNotation() {
        LinkedList<String> pol2 = new LinkedList<>();
        pol2.add("x");
        pol2.add("2");
        pol2.add("^");
        pol2.add("3");
        pol2.add("+");
        pol2.add("x");
        pol2.add("2");
        pol2.add("-");
        pol2.add("/");
        assertEquals(12, v.evaluatePolishNotation(pol2, 3));
    }

    // Testing invalid expression for binary operator
    @Test
    public void testInvalidExpressionForOperator() {
        LinkedList<String> pol3 = new LinkedList<>();
        pol3.add("x");
        pol3.add("+");
        assertThrows(IllegalArgumentException.class,
                () -> v.evaluatePolishNotation(pol3, 3),
                "Invalid expression for binary operator: +");
    }

    // Testing division by zero
    @Test
    public void testDivisionByZero() {
        LinkedList<String> pol4 = new LinkedList<>();
        pol4.add("x");
        pol4.add("0");
        pol4.add("/");
        assertThrows(ArithmeticException.class,
                () -> v.evaluatePolishNotation(pol4, 3),
                "Division by zero");
    }

    // Testing invalid operators
    @Test
    public void testInvalidOperators() {
        LinkedList<String> pol5 = new LinkedList<>();
        pol5.add("x");
        pol5.add("0");
        pol5.add("$");
        assertThrows(IllegalArgumentException.class,
                () -> v.evaluatePolishNotation(pol5, 3),
                "Unknown operator: $");
    }

    // Test empty expression
    @Test
    public void testEmptyExpression() {
        LinkedList<String> pol6 = new LinkedList<>();
        assertThrows(IllegalArgumentException.class,
                () -> v.evaluatePolishNotation(pol6, 3),
                "Empty expression");
    }

    // Test too many values for an operator
    @Test
    public void testTooManyValues() {
        LinkedList<String> pol7 = new LinkedList<>();
        pol7.add("1");
        pol7.add("3");
        pol7.add("2");
        pol7.add("+");
        assertThrows(IllegalArgumentException.class,
                () -> v.evaluatePolishNotation(pol7, 3),
                "Invalid expression: too many values");
    }

    //Test null output
    @Test
    public void testNullOutput() {
        assertEquals("The result is Undefined", v.output(null));
    }

    //Test normal output
    @Test
    public void testNormalOutput() {
        assertEquals("The result is 25", v.output("25"));
    }
}
