class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counts = {}
        for task in tasks: # Count up how many times each task in the "tasks" list is present.
            if task not in counts:
                counts[task] = 1
            else:
                counts[task] += 1

        taskHeap = []
        for task, count in counts.items(): # Add all task:count pairs to a Max Heap
            taskHeap.append([count * -1, task]) # Invert the count to make the heap a Max Heap.
        heapq.heapify(taskHeap)

        cooldown = deque() # A queue to keep track of tasks that are delayed due to a cooldown period (n).

        cycles = 0
        while taskHeap or cooldown: # Process tasks until there are no tasks left (tasks can exist in either the taskHeap or the cooldown queue)
            if cooldown and cooldown[-1][1] == cycles: # Check if the oldest task on the queue is ready to run again.
                heapq.heappush(taskHeap, cooldown.pop()[0]) # Items are added to the left and popped from the right.
            
            if taskHeap: # If there are tasks to process, process one.
                task = heapq.heappop(taskHeap) # Get the task to be processed.
                task[0] += 1 # Add one to reduce the task count b/c Max Heap stores the values as negatives.
                if task[0] < 0: # If there are tasks of this task's type left, push to cooldown; else, this task type is complete.
                    cooldown.appendleft([task, cycles + n + 1]) # + 1 b/c the current cycle doesn't count towards the cooldown. We need n cycles _between_ instructions of the same type.
            
            cycles += 1 # Increment the cycles counter.

        return cycles
        
# ***** IDEAS *****
# NeetCode
# > Use a Max Heap and a Queue to track the order in which to run each task and when to run a NOP.
# > Start by counting up the frequency of each instruction type (do this in a hash map), then add each instruction:count pair to a max heap.
# OUTLINE
# Instantiate a HashMap<instruction, count>
# Loop over tasks,
#   Increment HashMap value for each task
# Instantiate MaxHeap
# Loop to push all instruction:count pairs to the heap
# Heapify heap
# Instantiate queue
# Loop while heap and queue are not empty,
#   If heap not empty,
#     Pop heap
#     Decrement count in popped "tuple" (may need to use array b/c tuples are immutable)
#     Increment count
#     Push "tuple" to queue with extra value: releaseTime = currentTime + n
#   If queue.peek().releaseTime == count,
#     Pop queue and push popped value to MaxHeap
# Return count