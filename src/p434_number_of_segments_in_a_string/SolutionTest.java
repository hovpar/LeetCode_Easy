package p434_number_of_segments_in_a_string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsZero_whenEmptyString() {
        assertEquals(0, s.countSegments(""));
    }

    @Test
    void returnsOne_whenSingleWordNoSpaces() {
        assertEquals(1, s.countSegments("Hello"));
    }

    @Test
    void returnsFive_whenTypicalSentenceWithSpaces() {
        assertEquals(5, s.countSegments("Hello, my name is John"));
    }

    @Test
    void returnsZero_whenOnlySpaces() {
        assertEquals(0, s.countSegments("                "));
    }

    @Test
    void returnsOne_whenLeadingAndTrailingSpacesAroundWord() {
        assertEquals(1, s.countSegments("   Hello   "));
    }

    @Test
    void returnsTwo_whenMultipleSpacesBetweenWords() {
        assertEquals(2, s.countSegments("Hello     world"));
    }

    @Test
    void returnsThree_whenMixedWhitespaceSpacesTabsNewlines() {
        assertEquals(3, s.countSegments("a\tb\nc"));
    }

    @Test
    void returnsTwo_whenNewlinesAndSpacesAroundWords() {
        assertEquals(2, s.countSegments("\n  hello \n world \n"));
    }

    @Test
    void returnsZero_whenOnlyTabsAndNewlines() {
        assertEquals(0, s.countSegments("\t\n\n\t"));
    }

    @Test
    void countsPunctuationAsPartOfSegments_whenSeparatedByWhitespace() {
        assertEquals(3, s.countSegments("hi, there! :)"));
    }

    @Test
    void returnsOne_whenOnlyPunctuationNoWhitespace() {
        assertEquals(1, s.countSegments("..."));
    }

    @Test
    void returnsOne_whenSingleCharacterWord() {
        assertEquals(1, s.countSegments("a"));
    }

}
