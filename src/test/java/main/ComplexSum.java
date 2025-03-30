package main;

import java.util.Queue;

/**
 * Class for the complex summations E.G. sum from x=1 to 5 of (x^2+3)/(3*x)
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class ComplexSum extends Value implements Sum {
    public ComplexSum(String from, String to, Queue<String> val) {
        super(from, to, val);
    }

    @Override
    public String calculate() {
        int upperBound = Integer.parseInt(getTo());
        int lowerBound = Integer.parseInt(getFrom());
        double result = 0.0;

        // Calculates the value for each iteration of the sum
        for (int i = lowerBound; i <= upperBound; i++) {
            double value;
            try {
                value = evaluatePolishNotation(getValPolish(), i);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            }
            result += value;
        }

        // Returns the String of the result
        return String.valueOf(result);
    }
}
