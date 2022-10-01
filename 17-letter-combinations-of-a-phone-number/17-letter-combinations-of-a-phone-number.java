class Solution {
    
    /**
     * IDEA:
     * - Use backtracking to find all valid permutaitons of the given sets of letters.
     * 
     * SOURCES:
     * - Worked through this solution to understand the problem/solution and ultimately construct my soulution:
     *     - https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/798868/Java-Backtracking-with-some-comments-or-0ms-38-memory-usage
     */
    public List<String> letterCombinations(String digits) {
        
        // If `digits` is emtpy, no permutations possible, return an empty list
        if (digits.length() == 0) {
            return new ArrayList();
        }
        
        // Create a mapping (HashMap) of all digit -> character mappings on the phone keypad.
        // A Character is used to represent the digits b/c CharAt() will later be used to pull
        // the digits from the `digits` string later on.
        Map<Character, String> keyMap = new HashMap<Character, String>();
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
        
        // An ArrayList to store all of the permutations
        List<String> result = new ArrayList<String>();
        
        // A StringBuilder to be used to build the current solution
        StringBuilder currentPerm = new StringBuilder();
        recursiveLetterCombos(digits, keyMap, currentPerm, result, 0);
        
        return result;
    }
    
    /**
     * `index` is the index of the value in the list of possible values that is currently
     * under evaluation (being tested as an element in a permutatino)
     */
    private void recursiveLetterCombos(String digits, Map<Character, String> keyMap, StringBuilder currentPerm, List<String> result, int index) {
                
        
        // BASE CASE: If the current string (permuation) is the same length as `digits` the permutaiotn is complete
        if (currentPerm.length() == digits.length()) {
            result.add(currentPerm.toString());
            return;
        }
        
        // Loop over all possible values for the next element to be added to the current permutation
        for (int i = index; i < digits.length(); i++) {
            // Select the set of digits that can be chosen from to add to the permuattion.
            // Each element in this set will be used to generate a unique permutation.
            // ex. If `options` contains 3 characters, we will generate 3 permutations,
            // one for each digit in options.
            String options = keyMap.get(digits.charAt(i));
            
            // Loop over all of the options in `options` That is, explore all possible
            // decision trees for the given set of options at this juncture (decions point).
            for (int j = 0; j < options.length(); j++) {
                // Add the current option to the current permutation (currentPerm)
                currentPerm.append(options.charAt(j));
                // Explore the decision tree down the path following the most recently added option.
                recursiveLetterCombos(digits, keyMap, currentPerm, result, i + 1);
                // Remove the most recently added option from the current permutation to "backtrack"
                currentPerm.deleteCharAt(currentPerm.length() - 1);
            }
        }
    }
}