package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Main class
 *
 * @author Alexey Grushetzky
 * @version Mar 30, 2025
 */

class MainTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        Main.s = new Scanner(System.in); // Reset the scanner
    }

    // Helper method to provide input
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        Main.s = new Scanner(System.in); // Reset the scanner with the new input
    }

    @Test
    void testSetUpProcedures() {
        HashMap<Integer, ProcedureContainer> procedures = new HashMap<>();
        Main.setUpProcedures(procedures);

        assertEquals(2, procedures.size(), "Should setup 2 procedures");
        assertTrue(procedures.containsKey(1), "Should contain procedure 1");
        assertTrue(procedures.containsKey(2), "Should contain procedure 2");
        assertEquals("Basic Sum e.g. sum from x=1 to 5 of 17", procedures.get(1).description());
        assertEquals("Complex Sum e.g. sum from x=1 to 5 of (x^2+3)/(3*x)", procedures.get(2).description());

        // Check if output contains the menu
        String output = outContent.toString();
        assertTrue(output.contains("1."), "Output should display procedure 1");
        assertTrue(output.contains("2."), "Output should display procedure 2");
        assertTrue(output.contains("Which procedure do you need?"), "Output should ask for procedure choice");
    }

    @Test
    void testProcedureInputHandler_ValidChoice() {
        HashMap<Integer, ProcedureContainer> procedures = new HashMap<>();
        // Create a mock procedure for testing
        procedures.put(1, new ProcedureContainer(1, "Test", () -> System.out.println("Mock procedure executed")));

        Main.procedureInputHandler(1, procedures);

        assertEquals("Mock procedure executed\n", outContent.toString(),
                "Should execute the procedure for valid choice");
    }

    @Test
    void testProcedureInputHandler_InvalidChoice() {
        HashMap<Integer, ProcedureContainer> procedures = new HashMap<>();
        procedures.put(1, new ProcedureContainer(1, "Test", () -> {}));

        Main.procedureInputHandler(99, procedures);

        assertEquals("Operation not found\n", outContent.toString(),
                "Should display error for invalid choice");
    }

    @Test
    void testTakeSummationInput_ValidInput() {
        // Provide valid test input
        provideInput("1\n5\n10\n");

        String[] result = Main.takeSummationInput();

        assertEquals("1", result[0], "Lower bound should be 1");
        assertEquals("5", result[1], "Upper bound should be 5");
        assertEquals("10", result[2], "Expression should be 10");
    }

    @Test
    void testTakeSummationInput_EmptyInput() {
        // Provide empty input for the expression
        provideInput("1\n5\n\n");

        Exception exception = assertThrows(IllegalArgumentException.class,
                Main::takeSummationInput,
                "Should throw IllegalArgumentException for empty input");

        assertEquals("Error: Empty input", exception.getMessage(),
                "Exception message should indicate empty input");
    }

    @Test
    void testBaseSum_ValidInput() {
        // Mock BasicSum to verify it's used correctly
        // This requires making a mockable version of BasicSum or using a mocking framework
        // For simplicity, we'll test the output based on expected input/output
        provideInput("1\n5\n10\n");

        Main.baseSum();

        String output = outContent.toString();
        assertTrue(output.contains("Enter the lower bound"), "Should prompt for lower bound");
        assertTrue(output.contains("Enter the upper bound"), "Should prompt for upper bound");
        assertTrue(output.contains("Enter the expression"), "Should prompt for expression");
        // The actual result will depend on the BasicSum implementation
    }

    @Test
    void testBaseSum_InvalidInput() {
        provideInput("1\n5\n\n");

        Main.baseSum();

        assertTrue(outContent.toString().contains("Error: Empty input"),
                "Should display error for invalid input");
    }

    @Test
    void testComplexSum_ValidInput() {
        // Similar to baseSum test, but for ComplexSum
        provideInput("1\n5\nx^2\n");

        Main.complexSum();

        String output = outContent.toString();
        assertTrue(output.contains("Enter the lower bound"), "Should prompt for lower bound");
        assertTrue(output.contains("Enter the upper bound"), "Should prompt for upper bound");
        assertTrue(output.contains("Enter the expression"), "Should prompt for expression");
        // The actual result will depend on the ComplexSum and InputParser implementations
    }

    @Test
    void testComplexSum_InvalidInput() {
        provideInput("1\n\n10\n");

        Main.complexSum();

        assertTrue(outContent.toString().contains("Error: Empty input"),
                "Should display error for invalid input");
    }

    @Test
    void testMain_IntegrationTest() {
        // Integration test for the main method with procedure 1
        provideInput("1\n1\n5\n10\n");

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Which procedure do you need?"), "Should display procedure menu");
        assertTrue(output.contains("Enter the lower bound"), "Should prompt for lower bound");
        // Further assertions would depend on the actual output format of BasicSum
    }
}
