public class Solution {
    
    public bool IsAnagram(string s, string t) {
        
        if (s.Length != t.Length) {
            return false;
        }
        Console.WriteLine("Here 1");
        
        Dictionary<char, int> sFreq = new Dictionary<char, int>();
        Dictionary<char, int> tFreq = new Dictionary<char, int>();
        
        // Populate sFreq
        for (int i = 0; i < s.Length; i++) {
            
            char sCurrent = s[i];
            Console.WriteLine($"sCurrent: {sCurrent}");
            
            if (sFreq.ContainsKey(sCurrent)) {
                sFreq[sCurrent]++;
            } else {
                sFreq.Add(sCurrent, 1);
            }
            Console.WriteLine($"sFreq[{sCurrent}]: {sFreq[sCurrent]}");
        }
        Console.WriteLine("Here 2");
        
        // Populate tFreq
        for (int i = 0; i < t.Length; i++) {
            
            char tCurrent = t[i];
            Console.WriteLine($"tCurrent: {tCurrent}");
            
            if (tFreq.ContainsKey(tCurrent)) {
                tFreq[tCurrent]++;
            } else {
                tFreq.Add(tCurrent, 1);
            }
        }
        Console.WriteLine("Here 3");
        
        // Compare characrer frequencies
        for (int i = 0; i < s.Length; i++) {
            Console.WriteLine($"i: {i}");           
            
            char current = s[i];
            Console.WriteLine($"current: {current}");
            
            if (!sFreq.ContainsKey(current) || !tFreq.ContainsKey(current) || sFreq[current] != tFreq[current]) {
                // Console.WriteLine($"sFreq: {sFreq[current]}, tFreq: {tFreq[current]}");
                return false;
            }
        }
        Console.WriteLine("Here 4");
        
        return true;
    }
}