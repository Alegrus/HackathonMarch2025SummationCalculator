package calculator;

import java.util.Queue;

/**
 * Interface of the InputParser class
 *
 * @author Alexey Grushetzky
 * @version Mar 30, 2025
 */

public interface InputParserInterface {
    // Public function to access parser functionality
    Queue<String> parse(String input);
}
