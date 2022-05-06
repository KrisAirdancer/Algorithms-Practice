public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Utilize the properties of the bitwise or (XOR) operator to determine which element in the
    /// input list nums is the one that is not a duplicate. Specifically, if we loop over the entire
    /// input array and for each element, compare it to the previous result using XOR then store
    /// the output of the XOR operation in a variable, then on each successive iteration after this
    /// first one, we compare the current element to the stored result, by the end of the array
    /// the result variable will store the non-duplicate element (not its index).
    /// 
    /// This is because the XOR operator will output a set of binary digits that indicate the result
    /// of comparing each of the digits in the two values being compared. This means that the first
    /// comparision with the XOR will set the result variable to the value that does not have a
    /// duplicate. Onece a value's duplicate is found, a comparison to it will yield all zeros,
    /// or the non-duplicate value. Thus, after looping over the entire array, we will have the
    /// non-duplicate value as a result.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(1)
    /// 
    /// OUTLINE:
    /// If nums is length 1, return nums[0]
    /// Initialize int result
    /// Loop over nums with for loop
    ///     Store the output of nums[i] ^ nums[j] in result
    /// Return result
    /// 
    /// REFERENCES:
    /// Used this solution/guide to arrive at my answer: https://leetcode.com/problems/single-number/discuss/1772139/C%2B%2Bor-Explained-Everything-w-WHY-XOR-WORKSor-BRUTE-FORCE-TO-OPTIMIZEDor-STEP-BY-STEP-DRY-RUN
    /// Additional reading: https://docs.microsoft.com/en-us/dotnet/visual-basic/language-reference/operators/xor-operator
    /// 
    /// </summary>
    public int SingleNumber(int[] nums) {
        
        if (nums.Length == 0) {
            return nums[0];
        }
        
        int result = 0;
        
        foreach (int num in nums) {
            result = (result ^ num);
        }
        
        return result;
    }
}