package p242_valid_anagram;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
                arguments(Named.of("sorting solver", new SolutionVariants.SortingSolver())),
                arguments(Named.of("counting solver", new SolutionVariants.CountingSolver())));
    }

    @TestEachSolver
    void testValidAnagram(SolutionVariants.Solver solver) {
        assertTrue(solver.isAnagram("anagram", "nagaram"));
    }

    @TestEachSolver
    void testNotAnagramDifferentLetters(SolutionVariants.Solver solver) {
        assertFalse(solver.isAnagram("rat", "car"));
    }

    @TestEachSolver
    void testEmptyStringsAreAnagrams(SolutionVariants.Solver solver) {
        assertTrue(solver.isAnagram("", ""));
    }

    @TestEachSolver
    void testDifferentLengthStrings(SolutionVariants.Solver solver) {
        assertFalse(solver.isAnagram("a", "aa"));
    }

    @TestEachSolver
    void testSameCharactersDifferentFrequencies(SolutionVariants.Solver solver) {
        assertFalse(solver.isAnagram("aabb", "ab"));
    }
    //    LeetCode doesn't require these cases
    //    @TestEachSolver
    //    void testStringsWithUpperAndLowerCase(SolutionVariants.Solver solver) {
    //        // Depending on your implementation: this will fail unless normalized
    //        assertFalse(solver.isAnagram("Listen", "Silent"));
    //    }
    //
    //    @TestEachSolver
    //    void testUnicodeCharacters(SolutionVariants.Solver solver) {
    //        assertTrue(solver.isAnagram("еяз", "язе"));
    //    }
    //
    //    @TestEachSolver
    //    void testWhitespaceIsSignificant(SolutionVariants.Solver solver) {
    //        assertTrue(solver.isAnagram("a b", "ab "));
    //    }

    @TestEachSolver
    void testLongStrings(SolutionVariants.Solver solver) {
        String s = "aaaaabbbbbcccccdddde";
        String t = "eaaaaabbbbbcccccdddd";
        assertTrue(solver.isAnagram(s, t));
    }

}
