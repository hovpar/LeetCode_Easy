package p014_longest_common_prefix;

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
        return Stream.of(new SolutionVariants.RecursiveSolver(), new SolutionVariants.IterativeSolver());
    }

    @SolverTest
    void test(SolutionVariants.Solver s) {
        String[] strs = { "flower", "flow", "flight" };
        assertEquals("fl", s.longestCommonPrefix(strs));
    }

    @SolverTest
    void testEmpty(SolutionVariants.Solver s) {
        String[] strs = { "" };
        assertEquals("", s.longestCommonPrefix(strs));
    }

    @SolverTest
    void testSingleString(SolutionVariants.Solver s) {
        String[] strs = { "single" };
        assertEquals("single", s.longestCommonPrefix(strs)); // Single string should return itself
    }

    @SolverTest
    void testNoCommonPrefix(SolutionVariants.Solver s) {
        String[] strs = { "abc", "def", "ghi" };
        String[] strs2 = { "dog", "racecar", "car" };

        assertEquals("", s.longestCommonPrefix(strs)); // No common prefix
        assertEquals("", s.longestCommonPrefix(strs2));
    }

    @SolverTest
    void testAllStringsSame(SolutionVariants.Solver s) {
        String[] strs = { "test", "test", "test" };
        assertEquals("test", s.longestCommonPrefix(strs)); // All strings identical
    }

    @SolverTest
    void testWithEmptyStringInArray(SolutionVariants.Solver s) {
        String[] strs = { "prefix", "", "pre" };
        assertEquals("", s.longestCommonPrefix(strs)); // Any empty string makes prefix empty
    }

    @SolverTest
    void testLongStrings(SolutionVariants.Solver s) {
        String[] strs = { "longestprefixpossible", "longestprefix", "longestpref" };
        assertEquals("longestpref", s.longestCommonPrefix(strs)); // Long common prefix
    }

    @SolverTest
    void testCaseSensitivity(SolutionVariants.Solver s) {
        String[] strs = { "Case", "caseSensitive", "caseTest" };
        assertEquals("", s.longestCommonPrefix(strs)); // Case-sensitive comparison
    }

}
