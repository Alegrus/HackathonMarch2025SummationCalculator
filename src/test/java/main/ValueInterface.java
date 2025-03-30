package main;

import java.util.Queue;

/**
 * Interface of the Value class
 *
 * @author Alexey Grushetzky
 * @version Mar 30, 2025
 */

public interface ValueInterface extends SummationInterface {
    // Evaluates the Reverse Polish notation expression for some x
    double evaluatePolishNotation(Queue<String> polish, double x);

    // Outputs result to console
    String output(String result);
}
