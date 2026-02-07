package p412_fizz_buzz;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testInputIsOne() {
        var expected = List.of("1");
        assertEquals(expected, s.fizzBuzz(1));
    }

    @Test
    void testDivisibleBy3() {
        var expected = List.of("1", "2", "Fizz");
        assertEquals(expected, s.fizzBuzz(3));
    }

    @Test
    void testDivisibleBy5() {
        var expected = List.of("1", "2", "Fizz", "4", "Buzz");
        assertEquals(expected, s.fizzBuzz(5));
    }

    @Test
    void testDivisibleBy3and5() {
        var expected = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
                "14", "FizzBuzz");
        assertEquals(expected, s.fizzBuzz(15));
    }

}
