package calculator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * General class for all kinds of summations
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public class Summation implements SummationInterface {
    private String from;
    private String to;
    private String val;
    private Queue<String> fromPolish;
    private Queue<String> toPolish;
    private Queue<String> valPolish;

    public Summation(String from, String to, String val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }

    public Summation(String from, String to, Queue<String> valPolish) {
        this.from = from;
        this.to = to;
        this.valPolish = valPolish;
    }

    public Summation(Queue<String> fromPolish, Queue<String> toPolish, Queue<String> valPolish) {
        this.fromPolish = fromPolish;
        this.toPolish = toPolish;
        this.valPolish = valPolish;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getVal() {
        return val;
    }

    // Returns a copy of the valPolish to not modify original during calculation
    @Override
    public Queue<String> getValPolish() {
        if (valPolish != null) {
            return new LinkedList<>(valPolish);
        }
        return null;
    }

    // Returns a copy of the valPolish to not modify original during calculation
    @Override
    public Queue<String> getFromPolish() {
        if (fromPolish != null) {
            return new LinkedList<>(fromPolish);
        }
        return null;
    }

    // Returns a copy of the valPolish to not modify original during calculation
    @Override
    public Queue<String> getToPolish() {
        if (toPolish != null) {
            return new LinkedList<>(toPolish);
        }
        return null;
    }
}
