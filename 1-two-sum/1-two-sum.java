class Solution {
    public int[] twoSum(int[] input, int target) {
        		
		int[] output = new int[2];
		
		HashMap<Integer, Integer> foundValues = new HashMap<Integer, Integer>();
		
		for (int index = 0; index < input.length; index++) {
			
			if (foundValues.containsKey((target - input[index]))) {
				output[0] = foundValues.get(target - input[index]);
				output[1] = index;
				return output;
			} else {
				foundValues.put(input[index], index);
			}
		}
		return output;
    }
}