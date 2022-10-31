class Solution {
    
    /**
     * IDEA:
     * - Tokenize the input strings and then generate a mapping between them. While building the mapping,
     *   check the following conditions: 1) no token in pattern can map to more than one token in s;
     *   2) no token in s can be mapped to by more than one token in pattern. If either of these conditions
     *   fails, return false; else, if all tokens are processed without exception, return true. Once the mapping
     *   is made, finish looping over the entire string s to ensure that it matches the pattern
     * 
     * PERFORMANCE:
     * - Time Complexity: O(N) - Where N is the number of tokens in s and pattern. Looping over pattern
     *                    and s simultaneously will take O(N) time and tokenizing both will take O(N) time.
     *                    So, 
     * - Memory Complexity: 
     * 
     */
    public boolean wordPattern(String pattern, String s) {
        
        // Note: No need to tokenize pattern b/c String.charAt() runs in O(1) time complexity
        // Tokenize s
        
        // If pattern.length() != s.length(), return false
        
        // Create HashMap to store mapping
        
        // Create mapping between pattern and the first M tokens in s, where M is the length of pattern
        // Indexed for loop to loop over pattern and s
            // Grab current tokens
            // If map contains key,
                // If value for key matches new value, continue
                // Else, return false
            // If map does not contain key,
                // If map contains value, return false
                // Else, add key-value pair
        // If you make it this far and don't have to return early, return true
        
        String[] sTokens = s.split(" ");
        
        if (pattern.length() != sTokens.length) {
            return false;
        }
        
        HashMap<Character, String> mapping = new HashMap<Character, String>();
        
        for (int i = 0; i < sTokens.length; i++) {
            char pToken = pattern.charAt(i);
            String sToken = sTokens[i];
            
            if (mapping.containsKey(pToken)) { // mapping contains key
                if (!mapping.get(pToken).equals(sToken)) { // If current pToken maps to something other than sToken, pattern is broken
                    return false;
                }
            } else { // mapping doesn't contain key
                if (mapping.containsValue(sToken)) { // If sToken is already in the mapping (some other pToken maps to it), the pattern is broken
                    return false;
                } else {
                    mapping.put(pToken, sToken);
                }
            }
        }
        
        return true;        
    }
}


























