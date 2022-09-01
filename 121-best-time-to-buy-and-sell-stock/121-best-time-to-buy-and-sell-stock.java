class Solution {
    
    /**
     * IDEA: Use two pointers to loop over the array. The left pointer keeps track of the buy point,
     * while the left pointer looks for the optimal sell point. For each element visited by the right
     * pointer, the difference between that value and hte value at the left pointer is calculated.
     * If the new maxProffit (difference) is greater than one seen before, update maxProfit with the
     * new value. Additionally, for each element visited by the right pointer, if the value at the right
     * pointer is less than the value at the left poiner, move the left pointer to the position of
     * the right pointer.
     */ 
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int left = 0;
        
        for (int right = 0; right < prices.length; right++) {
            int currentProfit = prices[right] - prices[left];
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            
            if (prices[right] < prices[left]) {
                left = right;
            }
        }
        
        return maxProfit;
    }
}