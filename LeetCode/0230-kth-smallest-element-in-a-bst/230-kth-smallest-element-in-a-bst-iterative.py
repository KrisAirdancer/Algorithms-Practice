# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        nodesVisited = 0
        nodes = []
        current = root

        while current or nodes: # Loop while we still have nodes to process: 1) there is at least one element on the stack that needs to be processed, OR 2) the current node is not null (we have a right node that needs to be procesed).
            while current: # Traverse all of the way down the left path. (In-Order traversal goes all of the way down the left path before visiting each node on that path and then their right children). When we reach None, this loop breaks, indicating the end of the left path.
                nodes.append(current) # Push the current element to the stack. This loop visits the nodes the first time, but we need to process it the second time we visit it (after it is popped from the stack), so we push it to the stack so that we will visit it later. This ensures that we visit nodes in the correct order.
                current = current.left # Step further down the left path.
            
            current = nodes.pop() # Since the above loop (left path traversal) leaves current on a None node, we need to get that None node's parent node - it will be the node that we process on this iteration.
            nodesVisited += 1 # Update the count of nodes that we have visited thus far.
            if nodesVisited == k: # Since we are visiting nodes in-order and this is a BST, we will be visiting the smallest node first and the largest node last. We are visiting the nodes in sorted order. Thus, if we just keep counting up each time we visit a node, we will eventually reach the kth node when our count equals k.
                return current.val
            current = current.right # Now that we've processed the current node, we need to step down the right path. We step down the right path by a single node b/c we will have to visit the entire leftmost path of this right child node to ensure that we visit the smallest elements first.

        # Note: There is no `return` statement in this function b/c we are guaranteed that n == k. This means that we will always break on the "if n == k" statement above. However, if the problem didn't provide this guarantee, we would have to implement a different solution.
                
# ***** IDEAS *****
# IDEA 1:
# > If we were to find the smallest element in a BST, we would just traverse down the leftmost path until we reach the end. The node at the end of this path is the smallest in the tree.
# > We can modify this method to find the Kth smallest by traversing to the bottom of the leftmost path, then counting back up until we reach the Kth smallest.
# 
# NEETCODE:
# Use an in-order traversal to put all of the nodes in the BST into a sorted list. Then just grab the kth element out of it (index k - 1).
# 
# ***** OUTLINE *****
# RECURSIVE SOLUTION (not quite right)
# > 1) Traverse to the bottom of the leftmost path.
#   > Base Case: If currentNode == None, return 1
# > 2) If count == k, return currentNode.val
# 
# ***** PSEUDO-CODE *****
# NEETCODE (iterative):
# 
# Instantiate a stack (we'll be doing Depth-First traversal): nodes
# Push root to stack - if not None
# Loop while nodes stack is non-empty:
#     Pop top element off of the stack: currentNode
#     ...???
# 
# NEETCODE (recursive):
# 
# Instantiate nodes list (list of sorted nodes): nodesList
# Define kthSmallestHelper(nodesList, currentNode):
#     If currentNode is None:
#         Return
#     kthSmallestHelper(nodesList, currentNode.left)
#     nodesList.append(currentNode.val)
#     kthSmallestHelper(nodesList, currentNode.right)
# Call kthSmallestHelper(nodesList, root)
# Return nodesList[k - 1]
# 
# IDEA 1:
# 
# DRIVER
#     Call kthSmallestRecursive(root, k)
# NESTED HELPER: def kthSmallestRecursive(currentNode, k)
#     If currentNode == None,
#         Return 1 # 1 to indicate that the None node's parent is the first smallest node.
#     ...
#     If kthSmallestRecursive(currentNode.left, k) == k,
#         Return currentNode.val