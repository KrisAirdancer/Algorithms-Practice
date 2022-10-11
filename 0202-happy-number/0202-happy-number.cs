public class Solution {
    
    /**
     * IDEA:
     * - Per the problem statement, we have two potential cases:
     *       1) n reduces to 1
     *       2) The n does not reduce to 1 and instead gets stuck in a cycle
     * - Use a loop to loop until n == 1 or until we're stuck in a loop. Use
     *   a second loop (inside the first) to pull all of the digits off of 
     *   n, square them, and then sum the results.
     * 
     */
    public bool IsHappy(int n) {
        
        HashSet<int> seenNums = new HashSet<int>();
        
        while (n != 1) { // Check if n has reduced to 1
            
            if (seenNums.Contains(n)) { return false; } // Check if we're in a loop
            
            seenNums.Add(n);
            
            // Calculate next value
            
            int sum = 0;
            
            while (n != 0) {    
                int digit = n % 10;
                n = n / 10;
                
                sum += (digit * digit);
            }
            
            n = sum;
        }
        
        return true;
    }
}