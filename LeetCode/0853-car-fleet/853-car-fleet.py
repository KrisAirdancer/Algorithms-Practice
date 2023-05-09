class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = [] # Instantiate an array to store the position-speed-timeToTarget triplets.
        # Populate the cars array.
        for pos, sp in zip(position, speed):
            timeToTarget = (target - pos) / sp # Calculate how long it will take for the current car to reach the target.
            cars.append((pos, sp, timeToTarget))

        cars = sorted(cars, reverse=True) # Sort the cars based on their distance to the target in descending order (closest to target on left).

        fleets = [] # Instantiate a stack to store the fleets of cars.

        for car in cars:
            fleets.append(car) # Push the current car to the stack.

            # If there are at least two cars on the stack AND the front car is slower than the behind car.
            #      timeToTarget of front car   timeToTarget of behind car
            if len(fleets) > 1 and fleets[-2][2] >= fleets[-1][2]:
                # Remove the car that will catch the slower car.
                fleets.pop()

        return len(fleets) # The stack should now contain the number of fleets that will arrive at the target.

# ***** INPUTS *****
# > An integer representing the distance between the start and end points.
# >> Note that n will be no larger than the number of vehicles b/c each unit of distance can house only a single car at a time.
# > An array of integers representing the position of each vehicle from some starting point 0.
# >> The array is not sorted. That is, the car in the leftmost position is not necessarily the closest or farthest from the end point.
# > An array of integers representing the speed of each vehicle
# ***** OUTPUTS *****
# > An integer representing the number of "fleets" (groups of cars) that will arrive at the end point.
# ***** IDEAS *****
# IDEA 1
# > Since the position array isn't sorted, it might be benificial to sort it.
# >> If the position array is sorted, then we will be able to know which vehicle is directly behind another.
# >> If we are to sort the input array, we must first pair all of the position and speed values and place those pairs into a separate array. It is this array that we will sort (based on position) so that we preserve the mapping between the position and speed values. Ex. (position, speed) <- tuple
# > Will also have to account for cars that are closer to the target arriving at the target before faster cars behind them can catch up.
# > Might be able to push each fleet to a stack to keep track of them.
# >> Iterate over the sorted input arrays and add each car to the stack. If the car is faster than the fleet on the top of the stack, add it to the stack...This isn't a complete solution...
# NEETCODE
# > The basic idea behind this problem is that we can calculate the time at which each car will arrive at the target. Then, we can compare those times. Any car that will arrive at the target before the one in front of it, will merge with the car in front of it to become a fleet.
# > This will require that we pair the values in the position and speed arrays and then sort those pairs based on their distance from the target (largest distance on the left means descending order).
# > From this, we can iterate over the sorted list of pairs and calculate the timeToTarget for the current element and the one behind it. If the car behind the current one has a timeToTarget that is less than the current car, they will be grouped as a fleet.
# > We keep track of the fleets by pushing each car to a stack and then comparing it to the car below it on the stack. If the two cars will merge to become a fleet, we pop the top car and leave the bottom one. By the time we are done, the stack will contain only the cars that mark the beginning of each of the fleets and we can just return the length of the stack.
# > timeToTarget = (target - position) / speed
# ***** OUTLINE *****
# Iterate over the input arrays and generate a new array of pairs
# Sort the array of pairs
# Instantiate a stack
# Loop: For each pair in pairs (start at the end of the array),
#     Push current pair to stack
#     If stack.size < 1 AND stack[-2].timeToTarget <= stack[-1].timeToTarget,
#         Pop top element from stack
# Return stack.length
# ***** PERFORMANCE *****
# Time Complexity: O(NlogN) - Since we are sorting the array of pairs (cars), we have a best case time complexity of O(NlogN), which is the time complexity of Python's built in sort: Tim Sort. Because this is slower than the O(N) time taken to iterate over the arrays, we have a final time complexity of O(N).
# Memory Complexity: O(N) - We are storing the two input arrays and a second array with the position, speed, and timeToTarget information. This means that we need O(3N) space, which reduces to O(N).
















