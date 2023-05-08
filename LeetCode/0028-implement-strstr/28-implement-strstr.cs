public class Solution {
    public int StrStr(string haystack, string needle) {
        
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