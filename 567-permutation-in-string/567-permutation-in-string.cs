public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        
        if (s1.Length > s2.Length) { return false; }
        
        int[] freq = new int[128];
        
        // Populate frequency array for s1
        for (int i = 0; i < s1.Length; i++) {
            char currentChar = s1[i];
            freq[currentChar]++;
        }
        
        int left = 0;
        int right = s1.Length - 1;
        
        // Shift right to correct starting position and update frequency array
        for (int i = 0; i < s1.Length; i++) {
            char currentChar = s2[i];
            freq[currentChar]--;
        }
        
        // Slide window (left & right pointers) over s2 to search for matching substrings
        while (right < s2.Length) {
            if (ContainsAllZeros(freq)) { return true; }
            freq[s2[left]]++;
            left++;
            right++;
            if (right < s2.Length) { freq[s2[right]]--; }
        }
        return false;
    }
    
    private bool ContainsAllZeros(int[] array) {
        for (int i = 0; i < array.Length; i++) {
            if (array[i] != 0) { return false; }
        }
        return true;
    }
}