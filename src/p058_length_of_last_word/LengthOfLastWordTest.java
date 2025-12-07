package p058_length_of_last_word;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LengthOfLastWordTest {

	@Test
	void test1() {
		assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello World"));
		assertEquals(4, LengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
		assertEquals(6, LengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
	}
	
	@Test
	void test2() {
		assertEquals(1, LengthOfLastWord.lengthOfLastWord("a"));
	}
	@Test
	void test3() {
		assertEquals(1, LengthOfLastWord.lengthOfLastWord("a  "));
	}
	@Test
	void test4() {
		assertEquals(0, LengthOfLastWord.lengthOfLastWord(" "));
	}
}
