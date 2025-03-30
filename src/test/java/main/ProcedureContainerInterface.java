package main;

/**
 * Interface of the ProcedureContainer class
 *
 * @author Alexey Grushetzky
 * @version Mar 30, 2025
 */

public interface ProcedureContainerInterface {
    int choice();

    String description();

    Runnable procedure();
}
