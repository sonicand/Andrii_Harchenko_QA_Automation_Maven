package calctest;

import org.hillel.calculator.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PersonTest {


    @ParameterizedTest
    @MethodSource("integerStreamProvider")
    public void divisionTestWithParams(List<Person> p) {
        Assertions.assertEquals(p.get(0), p.get(1));
        Assertions.assertEquals(p.get(0).getName(), p.get(1).getName());
    }

    public static Stream<Arguments> integerStreamProvider() {
        return Stream.of(
                Arguments.arguments(List.of(new Person("John"), new Person("John"))),
                Arguments.arguments(List.of(new Person("Dan"), new Person("Dan"))));
    }
}
