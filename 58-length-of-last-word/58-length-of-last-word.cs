public class Solution {
    
    /// <summary>
    /// Loop while currentChar == ' ', do nothing
    /// While currentChar != ' ',  increment count
    /// Return count
    /// </summary>
    public int LengthOfLastWord(string s) {
        
        int index = s.Length - 1;
        // Step past whitespace at end of 
        while (index >= 0 && s[index--] == ' ') { /* Do nothing */ }
        index++;
        
        int wordLength = 0;
        
        while (index >= 0 && s[index] != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}