package LongestCommonPrefix_14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {
	
	LongestCommonPrefix prefix = new LongestCommonPrefix();

	@Test
	void test() {
		String[] strs = { "flower", "flow", "flight" };
        
        assertEquals("fl", prefix.longestCommonPrefix(strs));
	}
	
	@Test
	void testEmpty() {
		String[] strs = { "" };

        assertEquals("", prefix.longestCommonPrefix(strs));
	}
	@Test
    void testSingleString() {
        String[] strs = { "single" };
        
        assertEquals("single", prefix.longestCommonPrefix(strs)); // Single string should return itself
    }

    @Test
    void testNoCommonPrefix() {
        String[] strs = { "abc", "def", "ghi" };
        String[] strs2 = { "dog", "racecar", "car" };
        
        assertEquals("", prefix.longestCommonPrefix(strs)); // No common prefix
        assertEquals("", prefix.longestCommonPrefix(strs2));
    }

    @Test
    void testAllStringsSame() {
        String[] strs = { "test", "test", "test" };
        
        assertEquals("test", prefix.longestCommonPrefix(strs)); // All strings identical
    }

    @Test
    void testWithEmptyStringInArray() {
        String[] strs = { "prefix", "", "pre" };
        
        assertEquals("", prefix.longestCommonPrefix(strs)); // Any empty string makes prefix empty
    }

    @Test
    void testLongStrings() {
        String[] strs = { "longestprefixpossible", "longestprefix", "longestpref" };
        assertEquals("longestpref", prefix.longestCommonPrefix(strs)); // Long common prefix
    }

    @Test
    void testCaseSensitivity() {
        String[] strs = { "Case", "caseSensitive", "caseTest" };
        assertEquals("", prefix.longestCommonPrefix(strs)); // Case-sensitive comparison
    }

}
