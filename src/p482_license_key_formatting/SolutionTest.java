package p482_license_key_formatting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void formatsExampleWithGroupSizeFour() {
        assertEquals("5F3Z-2E9W", s.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    @Test
    void formatsExampleWithGroupSizeTwo() {
        assertEquals("2-5G-3J", s.licenseKeyFormatting("2-5g-3-J", 2));
    }

    @Test
    void returnsSingleGroupWhenLengthIsSmallerThanK() {
        assertEquals("ABC", s.licenseKeyFormatting("abc", 4));
    }

    @Test
    void returnsSingleGroupWhenLengthEqualsK() {
        assertEquals("ABCD", s.licenseKeyFormatting("ab-cd", 4));
    }

    @Test
    void createsShorterFirstGroupWhenNeeded() {
        assertEquals("A-BCDE-FGHI", s.licenseKeyFormatting("a-bcde-fghi", 4));
    }

    @Test
    void removesAllExistingDashesBeforeReformatting() {
        assertEquals("ABC-DEF", s.licenseKeyFormatting("--a-b--c---d-e-f--", 3));
    }

    @Test
    void convertsAllLettersToUppercase() {
        assertEquals("ABC-DEF", s.licenseKeyFormatting("abC-dEf", 3));
    }

    @Test
    void keepsDigitsUnchanged() {
        assertEquals("12-34-56", s.licenseKeyFormatting("12-34-56", 2));
    }

    @Test
    void handlesMixedLettersAndDigits() {
        assertEquals("24A0-R74K", s.licenseKeyFormatting("2-4A0r7-4k", 4));
    }

    @Test
    void returnsEmptyStringWhenInputContainsOnlyDashes() {
        assertEquals("", s.licenseKeyFormatting("----", 3));
    }

    @Test
    void handlesSingleCharacter() {
        assertEquals("Z", s.licenseKeyFormatting("z", 1));
    }

    @Test
    void handlesGroupSizeOne() {
        assertEquals("A-B-C-1-2-3", s.licenseKeyFormatting("abc123", 1));
    }

    @Test
    void handlesVeryLargeGroupSize() {
        assertEquals("ABC123", s.licenseKeyFormatting("a-b-c-1-2-3", 20));
    }

    @Test
    void handlesInputEndingWithDashes() {
        assertEquals("ABC-DEF", s.licenseKeyFormatting("abc-def---", 3));
    }

    @Test
    void handlesInputStartingWithDashes() {
        assertEquals("ABC-DEF", s.licenseKeyFormatting("---abc-def", 3));
    }
}
