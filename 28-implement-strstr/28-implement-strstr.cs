public class Solution {
    public int StrStr(string haystack, string needle) {
        
        // Loop over all chars in haystack
            // If haystack[i] == needle[0],
                // Loop over haystack[i] to haystack[needle.Length],
                    // If haystack[j] != needle[0 + j], ...
        // If entire loop complets, return false
        
        if (needle.Equals("")) { return 0; }
        if (needle.Length > haystack.Length) { return -1;}
        
        for (int i = 0; i < haystack.Length; i++) {
            
            if (haystack[i] == needle[0]) {
                
                int count = 0;
                int j = 0;
                while (j < needle.Length && i < haystack.Length) {
                    
                    if (haystack[i++] == needle[j++]) {
                        count++;
                    }
                }
                i = i - j; // Reset i
                
                if (count == needle.Length) {
                    return i;
                }
            }
        }
        return -1;
    }
}