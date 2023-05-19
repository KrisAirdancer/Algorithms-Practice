# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # THIS IS AN ITERATIVE BFS SOLUTION
        if not root:
            return 0

        maxDepth = 0
        nodes = deque()
        nodes.append((root, 1)) # Add element to right end of queue.

        while nodes:
            currentNode = nodes.popleft() # Get the current node from the left of the queue.
            print(currentNode[0].val)

            if currentNode[1] > maxDepth: # Update the maxDepth variable if necessary
                maxDepth = currentNode[1]

            # Push the child nodes to the queue.
            if currentNode[0].left:
                nodes.append((currentNode[0].left, currentNode[1] + 1))
            if currentNode[0].right:
                nodes.append((currentNode[0].right, currentNode[1] + 1))

        return maxDepth

# ITERATIVE BFS SOLUTION
# ***** EXPLANATION *****
# > We can use a queue to implement an Iterative BFS solution. We loop until the queue is empty. On each iteration, we pop the node on the top of the queue and then push the children of that node to the back of the queue (we just add them to the queue - queues are FIFO). In doing so, we will visit all of the nodes on one level before visiting any nodes on the next level down.
# > To record the maximum depth, we can push each node onto the stack as a tuple of (node, depth) and each time we pop a node, we check to see if its depth is greater than any we've seen before.
# > Note: Use queue.append() to add an element and queue.pop(0) to pop.
#   > We're adding elements to the right end and popping from the left end.
#   >                   <--- pop --- [1, 2, 3, 4, 5] <--- push ---