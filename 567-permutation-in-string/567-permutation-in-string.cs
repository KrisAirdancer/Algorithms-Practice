public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        
        if (s1.Length > s2.Length) { return false; }
        
        int[] freq = new int[128];
        
        // Populate frequency array for s1
        for (int i = 0; i < s1.Length; i++) {
            char currentChar = s1[i];
            freq[currentChar]++;
            // Console.WriteLine($"freq: {freq[currentChar]}");
        }
        
        int left = 0;
        int right = s1.Length - 1;
        
        // Shift right to correct starting position and update frequency array
        for (int i = 0; i < s1.Length; i++) {
            char currentChar = s2[i];
            freq[currentChar]--;
            // Console.WriteLine($"freq: {freq[currentChar]}");
        }
        
        // Console.WriteLine($"a: {freq[97]}, b: {freq[98]}, e: {freq[101]}, i: {freq[105]}");
        while (right < s2.Length) {
            // Console.WriteLine($"Left: {s2[left]}, {freq[s2[left]]}; Right: {s2[right]}, {freq[s2[right]]}");
            // Console.WriteLine($"e: {freq[101]}");
            if (ContainsAllZeros(freq)) { return true; }
            freq[s2[left]]++;
            left++;
            right++;
            if (right < s2.Length) { freq[s2[right]]--; }
            // Console.WriteLine($"freq: {freq[right - 1]}");
        }
        return false;
    }
    
    private bool ContainsAllZeros(int[] array) {
        for (int i = 0; i < array.Length; i++) {
            if (array[i] != 0) { return false; }
            // Console.WriteLine($"freq: {array[i]}");
        }
        return true;
    }
}