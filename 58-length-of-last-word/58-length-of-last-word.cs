public class Solution {
    
    public int LengthOfLastWord(string s) {
        
        int wordLength = 0;
        int index = s.Length - 1;
        
        // Step past whitespace at end of s to reach the last word in s
        while (index >= 0 && s[index] == ' ') { index--; }
        
        // Sum the length of the last word in s
        while (index >= 0 && s[index] != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}