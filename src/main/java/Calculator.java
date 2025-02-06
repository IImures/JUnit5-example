public class Calculator {

    // Adds two integers and returns the result.
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts the second integer from the first.
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two integers.
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divides the first integer by the second.
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }
}