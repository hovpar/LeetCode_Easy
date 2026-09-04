package p190_reverse_bits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("bit by bit solver", new SolutionVariants.BitByBitSolver())),
                arguments(Named.of("bit swap solver", new SolutionVariants.BitPermutationSolver())),
                arguments(Named.of("built in solver", new SolutionVariants.BuiltInFunctinSolver())));
    }

    @TestEachSolver
    void reversesExampleValue(SolutionVariants.Solver solver) {

        assertEquals(964176192, solver.reverseBits(43261596));

    }

    @TestEachSolver
    void reversesValueWithLeadingZeros(SolutionVariants.Solver solver) {

        assertEquals(1073741822, solver.reverseBits(2147483644));

    }

    @TestEachSolver
    void reversesZero(SolutionVariants.Solver solver) {

        assertEquals(0, solver.reverseBits(0));

    }

    @TestEachSolver
    void reversesOne(SolutionVariants.Solver solver) {

        assertEquals(Integer.MIN_VALUE, solver.reverseBits(1));

    }

    @TestEachSolver
    void reversesMostSignificantBit(SolutionVariants.Solver solver) {

        assertEquals(1, solver.reverseBits(Integer.MIN_VALUE));

    }

    @TestEachSolver
    void reversesAllBitsSet(SolutionVariants.Solver solver) {

        assertEquals(-1, solver.reverseBits(-1));

    }

    @TestEachSolver
    void reversesNegativeValue(SolutionVariants.Solver solver) {

        assertEquals(1073741825, solver.reverseBits(-2147483646));

    }

    @TestEachSolver
    void reversesAlternatingBits(SolutionVariants.Solver solver) {

        assertEquals(0x55555555, solver.reverseBits(0xAAAAAAAA));

    }

    @TestEachSolver
    void reversesOppositeAlternatingBits(SolutionVariants.Solver solver) {

        assertEquals(0xAAAAAAAA, solver.reverseBits(0x55555555));

    }

}
