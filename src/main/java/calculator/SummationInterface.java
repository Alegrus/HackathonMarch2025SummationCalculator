package calculator;

import java.util.Queue;

/**
 * Interface of the Summation class
 *
 * @author Alexey Grushetzky
 * @version Mar 30, 2025
 */

public interface SummationInterface {
    String getFrom();

    String getTo();

    String getVal();

    // Returns a copy of the valPolish to not modify original during calculation
    Queue<String> getValPolish();

    // Returns a copy of the valPolish to not modify original during calculation
    Queue<String> getFromPolish();

    // Returns a copy of the valPolish to not modify original during calculation
    Queue<String> getToPolish();
}
