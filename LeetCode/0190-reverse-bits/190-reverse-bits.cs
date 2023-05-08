public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Loop over the binary representation of the input uint n. For each bit in n, add that bit to an output
    /// uint. This can be done using the bit shift operators. We can determine whether each bit in n is a
    /// one or zero using the bitwise comparsion operator and comparing the current iteration of n to 1.
    /// If the current bit is a 1, we add a 1 to the return uint, if it is a 0, we add a 0.
    /// 
    /// It is important to note here that we must loop exactly 32 times (once for each of the 32 bits)
    /// because if we don't we won't properly add the correct number of zeros to the reversed bits and
    /// will thus generate the incorrect reversal.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(1) - Only ever loop 32 times for any uint that can be represented in a 32-bit system
    /// Memory Complexity: O(1) - Only need to store a single additional uint variable
    /// 
    /// OUTLINE: 
    /// Return 0 if n is zero - 0 reverses to 0
    /// Make unit return variable reversedBits
    /// Loop 32 times using for loop
    ///     Bit shift reversedBits to the left by one
    ///     If the current bit is a 1, add a one to reversedBits
    ///     Bit shift n to the right by one
    /// Return reversedBits
    /// 
    /// </summary>
    public uint reverseBits(uint n) {
        
        if (n == 0) {
            return 0;
        }
        
        uint reversedBits = 0;
        
        for (int i = 0; i < 32; i++) {            
            reversedBits = (reversedBits << 1); // This must be done before the assignment or we will add one too many zeros to result. This step is making a place for the next digit, but we only want to make a new space if we are actually going to add a new digit. On the last iteration, we add a digit but we also make a new space for the next digit even though the next iteration is not going to run. Thus, we will have added an extra zero when there shouldn't be one there.
            if ( (n & 1) == 1 ) {
                reversedBits++;
            }
            n = (n >> 1);
        }
        
        return reversedBits;
    }
}