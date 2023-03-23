package calctest;

import org.apiguardian.api.API;
import org.hillel.calculator.Calculation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.annotation.Testable;

import java.lang.annotation.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class CalcTest {

    private static Calculation calculation;

    @BeforeAll
    public static void init() {
        calculation = new Calculation();
        System.out.println("Before all");
    }
    @Test
    public void testMultiply() {
        Calculation calc = new Calculation();
        int result = calc.multiply(5, 6);
        Assertions.assertEquals(30, result, "Multiplication result is incorrect");
    }

    @Test
    public void testDivision() {
        Calculation calc = new Calculation();
        int result = calc.division(10, 2);
        Assertions.assertEquals(5, result, "Division result is incorrect");
    }

    @Test
    public void testAddition() {
        Calculation calc = new Calculation();
        int result = calc.addition(2, 3);
        Assertions.assertEquals(5, result, "Addition result is incorrect");
    }

    @Test
    void exceptionTesting() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculation.division(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("integerStreamProvider")
    //Argument
    public void testParametrizedDivision(int a, int b, int expected) {
        System.out.println("Test 1");
        int result = calculation.division(a, b);
        Assertions.assertEquals(result, expected, "Result is wrong: " + result);
    }

    public static Stream<Arguments> integerStreamProvider() {
        return Stream.of(
                Arguments.arguments(100, 10, 10),
                Arguments.arguments(10, 5, 2));
    }

}
