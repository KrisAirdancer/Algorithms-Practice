package problems_101_to_200;

public class BestTimeToBuyAndSellStock_II_122 {

	public static void main(String[] args) {
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		System.out.println(maxProfit(prices));
		
	}
	
    public static int maxProfit(int[] prices) {
        
    	int profit = 0;
    	int max = 0;
    	int min = 0;
    	boolean maxUpdated = false;
    	boolean minUpdated = false;
    	
    	for (int index = 0; index < prices.length; index++) {
    		
    		if (index == 0) { // index - 1 is out of bounds
    			if (prices[index] < prices[index + 1]) { // Check for Min at current index
    				min = prices[index];
    				minUpdated = true;
    			}
    			
    			if (prices[index] > prices[index + 1]) { // Check for Max at current index
    				max = prices[index];
    				maxUpdated = true;
    			}
    		} else if (index == prices.length - 1) { // index + 1 is out of bounds
    			if (prices[index] < prices[index - 1]) { // Check for Min at current index
    				min = prices[index];
    				minUpdated = true;
    			}
    			
    			if (prices[index] > prices[index - 1]) { // Check for Max at current index
    				max = prices[index];
    				maxUpdated = true;
    			}
    		} else { // index + 1 and index - 1 are in bounds
    			if (prices[index] < prices[index - 1] && prices[index] < prices[index + 1]) { // Check for Min at current index
    				min = prices[index];
    				minUpdated = true;
    			}
    			
    			if (prices[index] > prices[index - 1] && prices[index] > prices[index + 1]) { // Check for Max at current index
    				max = prices[index];
    				maxUpdated = true;
    			}
    		}
    		
    		// Update profit
    		if (minUpdated == true && maxUpdated == true) {
    			profit += (max - min);
    			
    			// Reset boolean flags
    			minUpdated = false;
    			maxUpdated = false;
    		}
    		
    	}
    	
    	return profit;
    }
}

/*
 * ***** TITLE *****
 *  RESTATEMENT OF PROBLEM:
 *  - Find the maximum amount of profit that could be gained from a given set of stock prices.
 *  
 *  SOLUTION IDEA:
 *  - Find the maximum and minimum values in the list of stock prices. Then, calculate the difference
 *  between the low-high sets (not the high-low sets), sum the differences, and return the final profit.
 *  
 *  FULL SOLUTION DESCRIPTION:
 *  
 *  DEFINITIONS OF VARIABLES & PARAMETERERS:
 *  
 *  PSEUDO-CODE SOLUTION:
 *  - Initialize profit variable
 *  - 
 *  
 */