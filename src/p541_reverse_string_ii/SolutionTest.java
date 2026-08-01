package p541_reverse_string_ii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest
    @MethodSource("solvers")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.SubstringSolver(), new SolutionVariants.CharArraySolver());
    }

    @SolverTest
    void reversesFirstKCharactersOfEachBlock(SolutionVariants.Solver s) {
        assertEquals("bacdfeg", s.reverseStr("abcdefg", 2));
    }

    @SolverTest
    void handlesExactlyTwoKCharacters(SolutionVariants.Solver s) {
        assertEquals("bacd", s.reverseStr("abcd", 2));
    }

    @SolverTest
    void reversesEntireStringWhenLengthIsLessThanK(SolutionVariants.Solver s) {
        assertEquals("cba", s.reverseStr("abc", 5));
    }

    @SolverTest
    void reversesEntireStringWhenLengthEqualsK(SolutionVariants.Solver s) {
        assertEquals("dcba", s.reverseStr("abcd", 4));
    }

    @SolverTest
    void reversesRemainingCharactersWhenFewerThanKRemain(SolutionVariants.Solver s) {
        assertEquals("bacdfe", s.reverseStr("abcdef", 2));
    }

    @SolverTest
    void reversesOnlyFirstKWhenBetweenKAndTwoKCharactersRemain(SolutionVariants.Solver s) {
        assertEquals("cbade", s.reverseStr("abcde", 3));
    }

    @SolverTest
    void handlesMultipleCompleteBlocks(SolutionVariants.Solver s) {
        assertEquals("cbadefihgjklonmp", s.reverseStr("abcdefghijklmnop", 3));
    }

    @SolverTest
    void returnsSameStringWhenKIsOne(SolutionVariants.Solver s) {
        assertEquals("abcdef", s.reverseStr("abcdef", 1));
    }

    @SolverTest
    void handlesSingleCharacter(SolutionVariants.Solver s) {
        assertEquals("a", s.reverseStr("a", 1));
    }

    @SolverTest
    void handlesRepeatedCharacters(SolutionVariants.Solver s) {
        assertEquals("aabbaa", s.reverseStr("aabbaa", 2));
    }

    @SolverTest
    void handlesOriginalSecondExample(SolutionVariants.Solver s) {
        assertEquals("abcd", s.reverseStr("bacd", 2));
    }
}
