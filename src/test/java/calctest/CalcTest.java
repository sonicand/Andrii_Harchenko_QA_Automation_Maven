package calctest;

import org.hillel.calculator.Calculation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {

    private static Calculation calculation;


    @BeforeAll
    public static void init() {
        calculation = new Calculation();
        System.out.println("Before all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }

    @Test
    public void testDivision() {
        System.out.println("Test 1");
        int result = calculation.division(10, 2);
        Assertions.assertEquals(5, result, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test addition 10 + 2")
    public void testAddition() {
        System.out.println("Test 1");
        int result = calculation.addition(10, 2);
        Assertions.assertFalse(result == 13, "Result is wrong: " + result);
    }

    @ParameterizedTest
    @MethodSource("integerStreamProvider")
    //Argument
    public void testAddition(int a, int b, int expected) {
        System.out.println("Test 1");
        int result = calculation.division(a, b);
        Assertions.assertEquals(result, expected, "Result is wrong: " + result);
    }

    public static Stream<Arguments> integerStreamProvider() {
        return Stream.of(
                Arguments.arguments(10, 5, 2),
                Arguments.arguments(8, 2, 4));
    }

    @Test
    void exceptionTesting() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculation.division(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }



    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

}
