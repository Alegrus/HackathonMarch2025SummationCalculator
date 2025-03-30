package calculator;

/**
 * Class for the most basic summations E.G. sum from x=1 to 5 of 17
 *
 * @author Alexey Grushetzky
 * @version Mar 28, 2025
 */

public class BasicSum extends Value implements Sum {
    public BasicSum(String from, String to, String val) {
        super(from, to, val);
    }

    @Override
    public String calculate() {
        int upperBound = Integer.parseInt(getTo());
        int lowerBound = Integer.parseInt(getFrom());
        int value = Integer.parseInt(getVal());
        int result = 0;

        // Calculates the sum within a simple for loop
        for (int i = lowerBound; i <= upperBound; i++) {
            result += value;
        }

        // Returns the String of the result
        return String.valueOf(result);
    }
}
