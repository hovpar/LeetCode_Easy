package p035_search_insert_position;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchInsertPositionTest {

	@Test
	void testCase1() {
		int [] nums = {1,3,5,6};
		
		assertEquals(2, SearchInsertPosition.searchInsert(nums, 5));
	}
	@Test
	void testCase2() {
		int [] nums = {1,3,5,6};
		
		assertEquals(1, SearchInsertPosition.searchInsert(nums, 2));
	}
	@Test
	void testCase3() {
		int [] nums = {1,3,5,6};
		
		assertEquals(4, SearchInsertPosition.searchInsert(nums, 7));
	}

}
