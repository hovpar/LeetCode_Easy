package _28FindIndexOfFirstOccurenceInAString;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class FindIndexOfFirstOccurenceInStringTest {

	@Test
	void test() {
		assertEquals(0, FindIndexOfFirstOccurenceInString.strStr("sadbutsad", "sad"));
	}
	
	@Test
	void test1() {
		assertEquals(0, FindIndexOfFirstOccurenceInString.strStr("a", "a"));
	}
	
	@Test
	void test2() {
		assertEquals(-1, FindIndexOfFirstOccurenceInString.strStr("aaa", "bba"));
	}
	
	@Test
	void test3() {
		assertEquals(2, FindIndexOfFirstOccurenceInString.strStr("hello", "ll"));
	}
	@Test
	void test4() {
		assertEquals(-1, FindIndexOfFirstOccurenceInString.strStr("leetcode", "leeto"));
	}
}
