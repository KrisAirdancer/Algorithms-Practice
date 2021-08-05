package problems_900_to_999;

import java.util.Arrays;

public class PrisionCellsAfterNDays_957 {

	public static void main(String[] args) {
		
		int[] cells = {0,1,0,1,1,0,0,1};
		
		System.out.println("Actual Output:   " + Arrays.toString(prisonCells_A1(cells, 7)));
		System.out.println("Expected Output: [0, 0, 1, 1, 0, 0, 0, 0]");

	}

	/**
	 * Attempt 1 - August 5, 2021
	 * 
	 */
	public static int[] prisonCells_A1(int[] cells, int days) {
		// Create new array to hold the state of the input array before the next cycle begins
		int[] previous = new int[cells.length];
		
		for (int day = 0; day < days; day++) {
			// Copy cells to previous
			for (int i = 0; i < cells.length; i++) {
				previous[i] = cells[i];
			}
			
			for (int index = 0; index < cells.length; index++) {				
//				System.out.println("previous: " + Arrays.toString(previous));
//				System.out.println("index: " + index);
				if (index == 0 || index == cells.length - 1) { // Update status of first and last cells
					cells[index] = 0; // The end cells in this implementation will always revert to vacant
					
				} else if (previous[index - 1] == previous[index + 1]) { // Make cells occupied
					cells[index] = 1;
//					System.out.println("Previous: " + previous[index - 1] + ", Next: " + previous[index + 1]);
							
				} else { // Make cells vacant
					cells[index] = 0;
					
				}
			}
		}
		return cells;
	}
	
}
