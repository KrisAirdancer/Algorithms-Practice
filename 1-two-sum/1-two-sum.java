class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Create new hashmap
        // Loop over the input array
            // Check if target - current is in hashmap
                // If not, continue
                // If yes, store current indicies in return int[] and break out of loop
            // Add current element to hashmap
        // Return indicies
        
        int[] indicies = new int[2];
        
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(target - nums[i])) {
                indicies[0] = numbers.get(target - nums[i]);
                indicies[1] = i;
                break;
            }
            numbers.put(nums[i], i);
        }
        return indicies;
    }
}