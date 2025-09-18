package _20ValidParentheses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void testIsValid() {
        assertTrue(validParentheses.isValid("()"));
        assertTrue(validParentheses.isValid("()[]{}"));
        assertTrue(validParentheses.isValid("([])"));
        
        assertFalse(validParentheses.isValid("(]"));
        assertFalse(validParentheses.isValid("([)]"));
        assertFalse(validParentheses.isValid("(("));
        assertFalse(validParentheses.isValid("){"));
        assertFalse(validParentheses.isValid("(){}}{"));
        assertFalse(validParentheses.isValid("([}}])"));
    }

}
