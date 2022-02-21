package chapter_2;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDups {
	
    static class LinkedListNode {
        int data;
        LinkedListNode next;
        
        LinkedListNode(int data){
        	this.data = data;
        }
        
    }

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
	public static void removeDuplicates_1(LinkedList<Integer> input) {
		
	}

	/**
	 * Model Solution
	 * 
	 * Time Complexity: O(n) - constant time
	 * 
	 * Notes: 
	 * - This method is supposed to be a behavior (method) within a 
	 * LinkedList class. Therefore, this class is a LinkedList
	 */
	public static void removeDuplicates_ModelSolution(LinkedListNode node) {
		/* Use a HashSet to store values from our LinkedList b/c HashSets
		 * don't allow for the storage of duplicate values. Could use a
		 * HashMap, but they require key-value pairs and can accept duplicate
		 * values (not duplicate keys) and we need duplicate checking and 
		 * don't need the key functionality. */
		HashSet<Integer> set = new HashSet<Integer>();
		
		LinkedListNode previous = null;
		while (node != null) {
			/* Remove all future nodes that have the same value */
			if (set.contains(node.data)) {
				previous.next = node.next;
			} else {
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}
	
}
