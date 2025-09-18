package _26RemoveDuplicatesFromSortedArray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void removeDuplicatestest() {
        int[] nums= {1,1,2};
        
        int [] expectedNums = {1,2};
        
        assertEquals(2, RemoveDuplicatesFromSortedArray.removeDuplicates(nums));
        
        for (int i = 0; i < 2; i++) {
            //assert nums[i] == expectedNums[i];
            assertEquals(nums[i], expectedNums[i]);
        }
    }
    @Test
    void removeDuplicatestestLong() {
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        
        int [] expectedNums = {0,1,2,3,4};
        
        assertEquals(5, RemoveDuplicatesFromSortedArray.removeDuplicates(nums));
        
        for (int i = 0; i < 5; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

}
