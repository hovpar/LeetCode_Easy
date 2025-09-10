package RemoveElement_27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveElementTest {

    @Test
    void test1() {
        int[] nums = {3,2,2,3};
        int[] expectedNums = {2,2};
        
        assertEquals(expectedNums.length, RemoveElement.removeElement(nums, 3));
        
        for(int i = 0; i<expectedNums.length; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
        
    }
    @Test
    void test2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int[] expectedNums = {0,1,4,0,3};
        
        assertEquals(expectedNums.length, RemoveElement.removeElement(nums, 2));
        
        for(int i = 0; i<expectedNums.length; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
        
    }
}
