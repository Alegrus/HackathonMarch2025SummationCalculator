package main;

/**
 * Class for containing procedure names and a method
 *
 * @author Alexey Grushetzky
 * @version Mar 29, 2025
 */

public record ProcedureContainer(int choice, String description, Runnable procedure) implements ProcedureContainerInterface {}
