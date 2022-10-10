public class Solution {
    
    public int ClimbStairs(int n) {
        
        Dictionary<int, int> memo = new Dictionary<int, int>();

        return RecursiveClimbStairs(memo, n);
    }
    
    private int RecursiveClimbStairs(Dictionary<int, int> memo, int n) {
        // Console.WriteLine(n);

        if (memo.ContainsKey(n)) {
            return memo[n];
        }
        
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            int count = RecursiveClimbStairs(memo, n - 1) + RecursiveClimbStairs(memo, n - 2);
            // Console.WriteLine(count);
            memo.Add(n, count);
            return count;
        }
    }
}