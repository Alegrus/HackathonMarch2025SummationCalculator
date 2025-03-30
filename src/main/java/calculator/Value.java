package calculator;

import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * General class for all summations looking for some end value
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class Value extends Summation implements ValueInterface {

    public Value(String from, String to, String val) {
        super(from, to, val);
    }

    public Value(String from, String to, Queue<String> val) {
        super(from, to, val);
    }

    // Evaluates the Reverse Polish notation expression for some x
    @Override
    public double evaluatePolishNotation(Queue<String> polish, double x) {
        Stack<Double> stack = new Stack<>();

        while (!polish.isEmpty()) {
            String token = polish.remove();

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("x")) {
                stack.push(x);
            } else {
                // Binary operators
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression for binary operator: " + token);
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> {
                        if (b == 0) throw new ArithmeticException("Division by zero");
                        yield a / b;
                    }
                    case "^" -> Math.pow(a, b);
                    default -> throw new IllegalArgumentException("Unknown operator: " + token);
                };
                stack.push(result);
            }
        }

        // Handle the case where there's only one value in the expression
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        } else if (stack.size() > 1) {
            throw new IllegalArgumentException("Invalid expression: too many values");
        }

        return stack.pop();
    }

    // Outputs result to console
    @Override
    public String output(String result) {
        return "The result is " + Objects.requireNonNullElse(result, "Undefined");
    }

    // Checks whether a string is a valid number
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
