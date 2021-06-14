package chapter_2;

import java.util.LinkedList;

public class RemoveDups {

	public static void main(String[] args) {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		

	}
	
	/**
	 * Attempt 1 - FAILED
	 * 
	 * SOLUTION IDEA:
	 * - Sort the linked list, then loop over it once. While looping, if two
	 * neighboring values are the same, return false. If you make it through
	 * the entire list, return true.
	 * 
	 * - NOPE! Loop over the linked list and for each item in the list, increment a 
	 * corresponding index in a tracking array. On each loop, check to see if
	 * the most recently updated index in the tracking array is greater than
	 * one. If it is, return false. If you make it to the end of the linked list
	 * and haven't found any values larger than one in the tracking array, return
	 * true.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Create binary search algorithm that works on linked lists
	 * 
	 */
	public static void removeDuplicates(LinkedList<Integer> input) {
		
	}

}
