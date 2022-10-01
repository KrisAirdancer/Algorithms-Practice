class Solution {
    
    /**
     * IDEA:
     * - Recursively process the list. 
     * 
     * PERFORMANCE:
     * - Time Complexity:
     * - Memory Complexity: 
     * 
     * OUTLINE:
     * - 
     * 
     * SOURCES:
     * - Worked through this to reach my solution: https://programmer.help/blogs/leetcode-46-full-permutation-java-version.html
     * - Watched this for help understanding the solution: https://www.youtube.com/watch?v=s7AvT7cGdSo
     * 
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // A list of lists in which to store all of the permutations.
        List<Integer> mutableNums = new ArrayList<Integer>(); // An ArrayList to usee instead of nums[] b/c we need it to be mutable.
        for (int num : nums) { // Populate mutableNums
            mutableNums.add(num);
        }
        // Pass in the list of values (mutableNums), the return list (result), and an index value to track the current choice (the current num in the list of numbers).
        permuteRecursive(result, mutableNums, 0);
        return result;
    }
    
    /**
     * `index` is the current element in the list nums that is being chosen to add to the permutaiton.
     */
    private static List<List<Integer>> permuteRecursive(List<List<Integer>> result, List<Integer> nums, int index) {
        // Base Case: The index reaches the length of the nums list. This means that we've evaluated all values in the list.
        if (index == nums.size()) {
            // Add the current permutaion of nums to the return list.
            result.add(new ArrayList<Integer>(nums));
            return result;
        }
        
        for (int i = index; i < nums.size(); i++) {
            swap(nums, i, index); // Permute the current list (nums) of values by swapping two of the elements.
            permuteRecursive(result, nums, index + 1); // Chose the next item in the list for the next iteration with inext + 1.
            // Put the list (nums) of values back to its original state - before the first swap.
            swap(nums, i, index);
        }
        
        return result;
    }
    
    private static void swap(List<Integer> list, int first, int second) {
        int temp = list.get(second);
        list.set(second, list.get(first));
        list.set(first, temp);
    }
}