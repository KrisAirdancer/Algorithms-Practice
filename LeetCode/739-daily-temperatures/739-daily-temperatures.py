class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        lowerTemps = [] # Instantiate a Monotonic Decreasing stack to store temperatures lower than the current temperature.
        daysToHigherTemp = [0] * len(temperatures) # Instantiate a stack of all zeros and of the same length as the input array to be returned. This array stores the days until a higher temperature for each temp in temperatures.

        # Loop over all temperatures in the input temperature
        for i in range(len(temperatures)):
            # While the current temperature is higher than the temperatures on the stack.
            while len(lowerTemps) > 0 and temperatures[i] > lowerTemps[-1][0]:
                poppedTemp = lowerTemps.pop() # Get the top element off of the stack.
                daysToHigherTemp[poppedTemp[1]] = (i - poppedTemp[1]) # Calculate the number of days between the current element and the top of the stack and store it in the corresponding index of the output array.
                
            lowerTemps.append((temperatures[i], i)) # Push the current temperature to the stack along with its index.
        
        return daysToHigherTemp

# ***** INPUTS *****
# > An array of integers representing daily temperatures.
# ***** OUTPUTS *****
# > An array of integers representing the number of days until a warmer temperature.
# ***** IDEAS *****
# IDEA 1 - BFSol
# > Loop over the input array. For each element, loop until a higher temperature is found or until the end of the array is found. Store the number of days (steps away from the current day) in the output array at the index that corresponds to the current day.
# > This solution will run in O(N^2) time and take O(N) memory.
# NEETCODE
# > We use a Monotonic Decreasing stack arrangement to keep track of values that we are looking to find a larger value than. That is, as we iterate over the input array, if we find a value that is smaller than the element on the top of the stack, we push it to the stack. When we find a value that is greater than the value on the top of the stack, we pop the stack until the value on the top of the stack is larger than or equal to the current element or until the stack is empty, we then push the current element to the top of the stack. Additionally, while popping elements from the stack, we must populate the output array. For each element popped, we calculate the distance between the indicies of the current element and the element being popped, we then enter that value in the output array at the index of the element being popped.
# > To keep track of the index that each element on the stack is at in the input array, we can store the element on the stack as a tuple of (temperature, inputIndex).
# ***** PSEUDO-CODE *****
# Instantiate a stack
# Instantiate output array
# Loop: For each element in temperatures,
#     Loop: While current is greater than top of stack,
#         pop() stack
#         Set outputArr[indexOfPopped] to currentTemp - poppedTemp
#     Push current element to stack
# Note: We don't need to fill in any values that aren't followed by a greater temperature b/c we default initialized our stack to all zeros.
# Return outputArr
# ***** PERFORMANCE *****
# Time Complexity: O(N) - We only need to iterate over the input array once.
# Memory Complexity: O(N) - We need to store the input array plus the output array, so our memory complexity is O(2N) = O(N).