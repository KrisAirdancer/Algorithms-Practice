class Solution {
    
    /**
    * IDEA: 
    * - Create a character map using a HashMap that maps the characters in a to the characters
    * in b. Once the mapping is complete, use the mapping to convert a into a new string c. 
    * If the result of the conversion of a yields b, that is c == b, then the strings are
    * isomorphic. If c != b, then the strings are not isomorphic.
    * 
    * IMPLEMENTATION:
    * - No need to check that lengths match - instructions guarantee same length
    * - Make a new HashMap<Character, Character>
    * - Loop over both strings simultaneously,
    *     - Map the current character in a with the current character in b
    *     - (If mapping is already in HashMap, just continue)
    * - Make a new StringBuilder
    * - Loop over a and use the mapping in the HashMap to convert a into c.
    * - Return c == t
    * 
    * ALT:
    * - Make a HashMap to store the mappings from s to t
    * - Loop over both strings simultaneously
    *     - Pull the current characters
    *     - If HashMap contains s.current,
    *         - If s.current maps to t.current in HashMap, continue
    *         - Else, return false - mapping maps the same input to two different outputs
    *     - Else,
    *         - If HashMap does not contain t.current, add (s.current, t.current) to HashMap
    *         - Else, return false - mapping maps two inputs to one output
    * - Return true - if we get this far, the mapping will map s to t and vice versa
    */
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> mapping = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);
            
            if (mapping.containsKey(s_char)) {
                if (mapping.get(s_char).equals(t_char)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!mapping.containsValue(t_char)) {
                    mapping.put(s_char, t_char);
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}