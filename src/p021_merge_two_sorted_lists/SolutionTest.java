package p021_merge_two_sorted_lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        return Stream.of(new SolutionVariants.IterativeMergeSolver(), new SolutionVariants.RecursiveMergeSolver());
    }

    @SolverTest
    void testMergeTwoLists(SolutionVariants.Solver s) {

        // Test case where both lists are null
        assertNull(s.mergeTwoLists(null, null));

        // Test case where one list is null
        ListNode list1 = new ListNode(1);
        ListNode merged1 = s.mergeTwoLists(list1, null);
        assertEquals(1, merged1.val);
        assertNull(merged1.next);

        // Test case where both lists are non-empty
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list4.next = list5;

        ListNode merged2 = s.mergeTwoLists(list1, list4);
        assertEquals(1, merged2.val);
        assertEquals(2, merged2.next.val);
        assertEquals(3, merged2.next.next.val);
        assertEquals(4, merged2.next.next.next.val);
        assertEquals(5, merged2.next.next.next.next.val);
        assertNull(merged2.next.next.next.next.next);
    }

    @SolverTest
    public void testMergeTwoLists1(SolutionVariants.Solver s) {
        // Test case where both lists are non-empty with elements in sorted order
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode merged = s.mergeTwoLists(list1, list2);

        // Expected merged list: [1, 1, 2, 3, 4, 4]
        assertEquals(1, merged.val);
        assertEquals(1, merged.next.val);
        assertEquals(2, merged.next.next.val);
        assertEquals(3, merged.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.next.val);
        assertNull(merged.next.next.next.next.next.next);
    }
}
