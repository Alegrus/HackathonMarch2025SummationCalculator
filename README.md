# Summation Calculator

## Description
Summation Calculator is a Java program that allows users to compute summations based on a given mathematical expression. The program offers two summation procedures: a basic sum and a complex sum.

## Features
- Supports two types of summation:
    - **Basic Sum**: Computes the sum of a constant value over a given range.
    - **Complex Sum**: Computes the sum of a mathematical expression involving the summation variable.
- User-friendly command-line interface.
- Error handling for invalid input.

## Limitations
- Does not support trigonometric functions
- Requires generous use of parentheses

## Installation
I reccomend going through intellij and following this tutorial: https://www.youtube.com/watch?v=ZqxVJ9gEKo0

## Usage
1. Upon running the program, a menu will be displayed with available summation procedures.
2. Enter the number corresponding to the desired procedure.
3. Provide the required input:
    - Lower bound of the sum.
    - Upper bound of the sum.
    - Mathematical expression for the summation (only for Complex Sum).
4. The program will compute and display the result.

## Example
### Example 1: Basic Sum
**Input:**
```
Which procedure do you need? (enter the number): 1
Enter the lower bound of the sum: 1
Enter the upper bound of the sum: 5
Enter the expression that the sum calculates: 17
```
**Output:**
```
The result is: 85
```

### Example 2: Complex Sum
**Input:**
```
Which procedure do you need? (enter the number): 2
Enter the lower bound of the sum: 1
Enter the upper bound of the sum: 5
Enter the expression that the sum calculates: (x^2+3)/(3*x)
```
**Output:**
```
The result is: 7.283333333333333
```

## Stability and Scalability
- Extensive JUnit tests covering all aspects of the program
- Scalable separation of summation procedures by types of operations
- Works on an underlying Maven architecture, allowing for better scalability

## Requirements
- Java 21 or higher

## Author
Alexey Grushetzky

