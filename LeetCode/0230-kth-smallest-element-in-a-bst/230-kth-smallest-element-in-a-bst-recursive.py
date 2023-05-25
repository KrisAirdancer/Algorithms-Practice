# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        nodesList = []

        def kthSmallestHelper(nodes: List[int], currentNode: Optional[TreeNode]):
            if currentNode is None:
                return
            
            kthSmallestHelper(nodes, currentNode.left)
            nodes.append(currentNode.val)
            kthSmallestHelper(nodes, currentNode.right)

        kthSmallestHelper(nodesList, root)
        return nodesList[k - 1]

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