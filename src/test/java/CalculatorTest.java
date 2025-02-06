import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When using Calculator")
public class CalculatorTest {

   private Calculator calculator;

    @BeforeEach
    public void setCalculator(TestInfo testInfo, TestReporter testReporter){
        calculator = new Calculator();
        testReporter.publishEntry(String.format("Running test %S, with tags %S", testInfo.getDisplayName(), testInfo.getTags()));
    }

    @Nested
    @DisplayName("add method")
    class AddTest{
        @Test
        @DisplayName("when adding two positive numbers")
        public void addTwoPositiveNumbersTest(){
            int expected = 7;
            int actual = calculator.add(5, 2);
            assertEquals(expected, actual, "should return right sum");
        }

        @Test
        @DisplayName("when adding one negative one positive numbers")
        public void addTwoNegativeAndPositiveNumbersTest(){
            int expected = 1;
            int actual = calculator.add(5, -4);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("when adding two negative numbers")
        public void addTwoNegativeNumbersTest(){
            int expected = -4;
            int actual = calculator.add(-2, -2);
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Subtracting two numbers")
    public void subtractTwoNumbersTest(){
        int expected = 0;
        int actual = calculator.subtract(100,100);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Multiplying two numbers")
    public void multiplyTwoNumbersTest(){
//        int expected = 25;
//        int actual = calculator.multiply(5,5);
//        assertEquals(expected, actual);
        assertAll(
                () -> assertEquals(4, calculator.multiply(2,2)),
                () -> assertEquals(-4, calculator.multiply(2,-2)),
                () -> assertEquals(0, calculator.multiply(0,-2)),
                () -> assertEquals(4, calculator.multiply(-2,-2))
        );
    }

    @Test
    @DisplayName("Dividing two numbers")
    public void divideTwoNumbersTest(){
        int expected = 2;
        int actual = calculator.divide(8,4);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Dividing number by zero")
    public void divideNumberByZeroTest(){
        assertThrows(IllegalArgumentException.class, ()-> calculator.divide(2,0));
    }

    @Test
    @DisplayName("Calculate square area")
    @Disabled
    public void calculateSquareAreaTest(){ // Only to test @Disabled annotation
        fail("Not implemented");
    }
}
