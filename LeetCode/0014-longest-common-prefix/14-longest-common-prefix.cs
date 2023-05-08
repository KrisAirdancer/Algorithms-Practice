public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        
        if (strs == null || strs.Length == 0) { return ""; }
        if (strs.Length == 1) { return strs[0]; }
        
        string longestCommonPrefix = strs[0];
        
        for (int i = 0; i < strs.Length; i++) {
            string word = strs[i];
            string currentPrefix = "";
            
            for (int j = 0; (j < word.Length && j < longestCommonPrefix.Length); j++) {
                if (word[j] != longestCommonPrefix[j]) {
                    if (j == 0) {
                        return "";
                    } else {
                        break;
                    }
                } else {
                    currentPrefix += word[j];
                }
            }
            longestCommonPrefix = currentPrefix;
        }
        return longestCommonPrefix;
    }
}