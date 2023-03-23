package source;

import org.hillel.calculator.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Assertion {
    private final Calculation calculator = new Calculation();

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.addition(1, 1));
        assertEquals(4, calculator.multiply(2, 2),
                "The optional failure message is now the last parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("calculation",
                () -> assertEquals(8, calculator.multiply(5,2)),
                () -> assertTrue( calculator.multiply(2,4) == 9)
        );
    }

    @Test
    void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    int addition = calculator.division(10,2);
                    assertTrue(addition ==0);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(addition > 0),
                            () -> assertTrue(addition < 9)
                    );
                },
                () -> {
                    int addition = calculator.division(10,2);
                    assertTrue(addition ==0);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(addition > 0),
                            () -> assertTrue(addition < 9)
                    );
                }
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.division(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
}
