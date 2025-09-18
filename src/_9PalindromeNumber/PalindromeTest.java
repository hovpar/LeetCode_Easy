package _9PalindromeNumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {
	
	Palindrome palindrome = new Palindrome();

	@Test
	void testPositivePalindrome() {
		assertTrue(palindrome.isPalindrome(1221));
	}

	@Test
	void testSingleDigit() {
		assertTrue(palindrome.isPalindrome(7));
	}


	@Test
	void testNonPalindrome() {
		assertFalse(palindrome.isPalindrome(123));
	}

	@Test
	void testZero() {
		assertTrue(palindrome.isPalindrome(0));
	}

	@Test
	void testLargePalindrome() {
		assertTrue(palindrome.isPalindrome(123454321));
	}

	@Test
	void testNumberEndingWithZero() {
		assertFalse(palindrome.isPalindrome(120));
	}

}
