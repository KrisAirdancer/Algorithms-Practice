public class Solution {
    
    /// <summary>
    /// Loop over each item in digits from back to front
    ///     If the current digit is less than 9,
    ///         Incriment it
    ///         Return digits
    ///     else (it is 9),
    ///         set it to zero and continue looping
    /// If we finish the loop (without returning), we have a number that will be one digit larger than the original digits array
    /// Create a new array comprised of all zeros (if we make it this far, all other digits will have been set to zero)
    /// Set the leftmost value of this array to 1
    /// Return the new array
    /// </summary>
    public int[] PlusOne(int[] digits) {
                
        for (int i = digits.Length - 1; i >=0; i--) {
            
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        int[] longerByOne = new int[digits.Length + 1];
        longerByOne[0] = 1;
        
        return longerByOne;
    }
}