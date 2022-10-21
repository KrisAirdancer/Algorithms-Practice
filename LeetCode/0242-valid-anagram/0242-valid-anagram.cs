public class Solution {
    
    public bool IsAnagram(string s, string t) {
        
        if (s.Length != t.Length) {
            return false;
        }
        
        Dictionary<char, int> sFreq = new Dictionary<char, int>();
        Dictionary<char, int> tFreq = new Dictionary<char, int>();
        
        // Populate sFreq
        for (int i = 0; i < s.Length; i++) {
            
            char sCurrent = s[i];
            
            if (sFreq.ContainsKey(sCurrent)) {
                sFreq[sCurrent]++;
            } else {
                sFreq.Add(sCurrent, 1);
            }
        }
        
        // Populate tFreq
        for (int i = 0; i < t.Length; i++) {
            
            char tCurrent = t[i];
            
            if (tFreq.ContainsKey(tCurrent)) {
                tFreq[tCurrent]++;
            } else {
                tFreq.Add(tCurrent, 1);
            }
        }
        
        // Compare characrer frequencies
        for (int i = 0; i < s.Length; i++) { 
            
            char current = s[i];
            
            if (!sFreq.ContainsKey(current) || !tFreq.ContainsKey(current) || sFreq[current] != tFreq[current]) {
                return false;
            }
        }
        
        return true;
    }
}