package sortAlgorithms;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {


		int[] test = {23, 2, 36, 9, 68, 0, 2, 99, 5, 16, 9, 35, 0, 64, 6, 92, 4, 12, 2, 69, 6, 97, 9, 35};

		selectionSort_A4(test);
		
		System.out.println(Arrays.toString(test));
	}
	
	/**
	 * Attempt 4 - July 16, 2021
	 * 
	 * ALGORITHM EXPLANATION:
	 * - Split the array into sorted and unsorted partitions.
	 * - Search the unsorted partition for the smallest element (must traverse the entire partition).
	 * - Swap smallest element with first element in the unsorted partition.
	 * - Increment the sorted partition's size up by one.
	 * 
	 * SOLUITION OUTLINE:
	 * - Indexed for loop - index is firstUnsorted - stop when first unsorted is >= length() (one larger than the last element)
	 * 	- Initialize smallest variable to hold the index value of the smallest found element (initialize to first element in unsorted partition)
	 * 	- Indexed for loop to search the unsorted partition
	 * 		- if current element smaller than element at smallest, set smallest to current index
	 * 	- Swap firstUnsorted element with smallest element
	 */
	public static void selectionSort_A4(int[] input) {
		
		for (int firstUnsorted = 0; firstUnsorted < input.length; firstUnsorted++) {
			
			int smallest = firstUnsorted;
			
			for (int index = firstUnsorted + 1; index < input.length; index++) {
				if (input[index] < input[smallest]) {
					smallest = index;
				}
			}
			// Swap smallest element with firstUnsorted element
			int temp = input[smallest];
			input[smallest] = input[firstUnsorted];
			input[firstUnsorted] = temp;
		}
	}

	/**
	 * Attempt 3 - July 7, 2021
	 */
	public static void selectionSort_A3(int[] input) {
		// Loop over the entire array
		for (int firstUnsorted = 0; firstUnsorted < input.length; firstUnsorted++) {
			// Set the smallest index
			int smallest = firstUnsorted;
			// Loop over the entire unsorted partition
			for (int searchIndex = firstUnsorted; searchIndex < input.length; searchIndex++) {
				if (input[searchIndex] < input[smallest]) {
					smallest = searchIndex;
				}
			}
			// Swap firstUnsorted with smallest
			int temp = input[smallest];
			input[smallest] = input[firstUnsorted];
			input[firstUnsorted] = temp;
		}
		
	}
	
	/**
	 * Attempt 2 - July 7, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Create two pointers, a searchIndex and a firstLarger index
	 * - Initialize variable smallest to keep track of the index of the smallest found value
	 * - Loop over the array until firstLarger >= input.length (while firstLarger < input.length)
	 * 	 - Each loop, loop over the entire list from firstLarger to length - 1 with searchIndex
	 * to find the smallest value in the list. 
	 * 	- Swap firstLarger element with the smallest index element
	 * 
	 * 
	 */
	public static void selectionSort_A2(int[] input) {
		
		int firstLarger = 0;
		
		while (firstLarger < input.length) {
			
			int smallest = firstLarger;
			int searchIndex = firstLarger;
			
			while (searchIndex < input.length) {
				if (input[searchIndex] < input[smallest]) {
					smallest = searchIndex;
				}
				searchIndex++;
			}
			// Swap firstLarger and smallest
			int temp = input[smallest];
			input[smallest] = input[firstLarger];
			input[firstLarger] = temp;
			
			firstLarger++;
			
		}
	}
	
	/**
	 * Attempt 1
	 * 
	 * SOLUTION IDEA:
	 * - Split the array into two partitions, sorted and unsorted. Loop over the unsorted partition,
	 * each time finding the smallest element. Then swap the smallest element with the first element
	 * in the unsorted partition. Then increment the firstUnsorteed index up by one, effectively
	 * adding that next smallest element to the end of the sorted partition. 
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Initialize firstUnsorted to 0
	 * - while firstUnsorted < input.length -1 
	 * 		- Initialize smallest variable to firstUnsorted
	 * 		- for loop from firstUnsorted to input.length - 1
	 * 				- if input[index] < input[smallest]
	 * 					- Store index in smallest
	 * 		- swap firstUnsorted and smallest
	 * 		- Increment firstUnsorted 
	 * 
	 */
	public static void selectionSort_A1(int[] input) {
		// Initialize partition index
		int firstUnsorted = 0;
		// Loop over the array until the sorted partition is the same length as the whole array
		while (firstUnsorted < input.length - 1) {
			// Initialize variable to track the index of the smallest element found so far
			int smallest = firstUnsorted;
			// Loop over the unsorted partition to find the smallest unsorted value
			for (int index = firstUnsorted; index < input.length; index++) {
				// If a found value is smaller than the current smallest value, update smallest
				if (input[index] < input[smallest]) {
					smallest = index;
				}
			}
			// Swap the first unsorted element with the smallest unsorted element
			int temp = input[firstUnsorted];
			input[firstUnsorted] = input[smallest];
			input[smallest] = temp;
			// Increment the sorted partition size up by one
			firstUnsorted++;
		}
	}
}
