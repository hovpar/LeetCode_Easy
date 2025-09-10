package AddBinary_67;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddBinaryTest {

	@Test
	void test() {
		assertEquals("100", AddBinary.addBinary("11", "1"));
	}
	@Test
	void test1() {
		assertEquals("10101", AddBinary.addBinary("1010", "1011"));
	}
	
	@Test
	void testZero() {
		assertEquals("11", AddBinary.addBinary("11", "0"));
		assertEquals("11", AddBinary.addBinary("0", "11"));
	}
}
