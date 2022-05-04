public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// 
    /// 
    /// PERFORMANCE:
    /// Time Complexity: 
    /// Memory Complexity: 
    /// 
    /// OUTLINE: 
    /// 
    /// 
    /// </summary>
    public uint reverseBits(uint n) {
        
        if (n == 0) {
            return 0;
        }
        
        uint result = 0;
        // Console.WriteLine($"n: {Convert.ToString(n, 2)}, result: {Convert.ToString(result, 2)}");
        
        for (int i = 0; i < 32; i++) {            
            result = (result << 1); // This must be done before the assignment or we will add one too many zeros to result. This step is making a place for the next digit, but we only want to make a new space if we are actually going to add a new digit. On the last iteration, we add a digit but we also make a new space for the next digit even though the next iteration is not going to run. Thus, we will have added an extra zero when there shouldn't be one there.
            if ( (n & 1) == 1 ) {
                result++;
            }
            n = (n >> 1);
        }
        
        return result;
    }
}