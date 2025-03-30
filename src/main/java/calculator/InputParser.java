package calculator;

import java.util.*;

/**
 * Class for parsing various user inputs
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class InputParser implements InputParserInterface {

    // Public function to access parser functionality
    @Override
    public Queue<String> parse(String input) {
        return convertInput(formatInput(input));
    }

    // Processes input to be more suited for further evaluation
    private String formatInput(String input) {
        // Remove all spaces
        input = input.replaceAll(" ", "");

        // Changes parentheses multiplication into normal for numbers
        input = input.replaceAll("(\\d)\\(", "$1*(");

        // Changes parentheses multiplication into normal for x
        input = input.replaceAll("(x)\\(", "x*(");

        return input;
    }

    // Converts the input to Reverse Polish notation
    private Queue<String> convertInput(String input) {
        Queue<String> output = new LinkedList<>();
        Stack<String> operators = new Stack<>();

        StringBuilder numberBuilder = new StringBuilder();
        boolean lastWasNumber = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // If it's a digit or a decimal point, append to current number
            if (Character.isDigit(c) || c == '.') {
                numberBuilder.append(c);
                lastWasNumber = true;
            } else {
                // Automatically add the variable to output
                if (c == 'x') {
                    output.add(String.valueOf(c));
                }

                // Push any completed number to output
                if (lastWasNumber) {
                    output.add(numberBuilder.toString());
                    numberBuilder = new StringBuilder();
                    lastWasNumber = false;
                }

                // Checks validity of parentheses placement
                if (c == '(') {
                    operators.push(Character.toString(c));
                } else if (c == ')') {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        output.add(operators.pop());
                    }

                    if (!operators.isEmpty()) {
                        operators.pop();
                    } else {
                        throw new IllegalArgumentException("Mismatched parentheses");
                    }
                // Adds the operator after the expression in the output
                } else if (isOperator(c)) {
                    String op = Character.toString(c);
                    while (!operators.isEmpty() && !operators.peek().equals("(") &&
                            precedence(operators.peek()) >= precedence(op)) {
                        output.add(operators.pop());
                    }
                    operators.push(op);
                }
            }
        }

        // Adds the last number if there is one
        if (lastWasNumber) {
            output.add(numberBuilder.toString());
        }

        // Pops all remaining operators to the output
        while (!operators.isEmpty()) {
            String op = operators.pop();
            if (op.equals("(")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(op);
        }

        return output;
    }

    // Checks whether a character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Checks precedence of operators
    private int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> 0;
        };
    }
}
