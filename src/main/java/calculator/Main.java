package calculator;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<Integer, ProcedureContainer> procedures = new HashMap<>();
        setUpProcedures(procedures);
        procedureInputHandler(Integer.parseInt(s.nextLine()), procedures);
    }

    // Sets up and prints all available procedures
    static void setUpProcedures(HashMap<Integer, ProcedureContainer> procedures) {
        procedures.put(1, new ProcedureContainer(
                1,
                "Basic Sum e.g. sum from x=1 to 5 of 17",
                Main::baseSum));
        procedures.put(2, new ProcedureContainer(
                2,
                "Complex Sum e.g. sum from x=1 to 5 of (x^2+3)/(3*x)",
                Main::complexSum));
        for (int key : procedures.keySet()) {
            ProcedureContainer pc = procedures.get(key);
            System.out.println(pc.choice() + ". " + pc.description());
        }
        System.out.print("Which procedure do you need? (enter the number): ");
    }

    // Checks if procedure given exists and runs it if so
    static void procedureInputHandler(int choice, HashMap<Integer, ProcedureContainer> procedures) {
        if (!procedures.containsKey(choice)) {
            System.out.println("Operation not found");
            return;
        }
        procedures.get(choice).procedure().run();
    }

    // Helper method to take parameters for sums
    static String[] takeSummationInput() {
        System.out.print("Enter the lower bound of the sum: ");
        String from = s.nextLine();
        System.out.print("Enter the upper bound of the sum: ");
        String to = s.nextLine();
        System.out.print("Enter the expression that the sum calculates: ");
        String value = s.nextLine();
        if (from.isBlank() || to.isBlank() || value.isBlank()) {
            throw new IllegalArgumentException("Error: Empty input");
        }
        return new String[] {from, to, value};
    }

    // Collecting input and outputting the result of basic sum
    public static void baseSum() {
        String[] sumParameters;
        try {
            sumParameters  = takeSummationInput();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }
        BasicSum bs = new BasicSum(sumParameters[0], sumParameters[1], sumParameters[2]);
        System.out.println(bs.output(bs.calculate()));
    }

    // Collecting input and outputting the result of complex sum
    public static void complexSum() {
        String[] sumParameters;
        try {
            sumParameters  = takeSummationInput();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }
        InputParser ip = new InputParser();
        ComplexSum cs = new ComplexSum(sumParameters[0], sumParameters[1], ip.parse(sumParameters[2]));
        System.out.println(cs.output(cs.calculate()));
    }
}