# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # AN IMPROVED SOLUTION TO THIS PROBLEM (better than my first solution)
    def goodNodes(self, root: TreeNode) -> int:
        return self.goodNodesRecursive(root, root.val)
    
    def goodNodesRecursive(self, current: TreeNode, largestSoFar: int):
        if not current: # If we've reached a null node, return.
            return 0
        
        if current.val > largestSoFar: # If the current node is larger than any other we've seen.
            largestSoFar = current.val

        if current.val >= largestSoFar: # If the current node is a Good Node.
            count = 1
        else:
            count = 0
        
        count += self.goodNodesRecursive(current.left, largestSoFar)
        count += self.goodNodesRecursive(current.right, largestSoFar)

        return count

# ***** IDEAS *****
# IDEA 1:
# > Notes:
#   > The root node is always a good node.
#   > A node is good if there are no nodes larger than (>) it along the path from the root to the node.
#   > If there is a node on the path from root to target that is equal to target, the target is still good.
# > If we traverse the tree DFS style and keep track of the largest value we've seen so far, we should be able to determine if each node is a good node.
#   > That is, a good node is larger than or equal to all other nodes on the path between it and the root (including the root). Thus, during a traversal, we only need to know if the current node is larger than or equal too all other nodes along that same path. If it is, it is a good node. Conversely, if the node is NOT less than the largestSoFar, it IS a good node.
# 
# ***** OUTLINE *****
# A recursive soltuion might be the easiest here so we don't have to keep track of different greatestSoFar values - we can just pass it down through recursive calls.
# DRIVER
#     Instantiate a return array: goodNodes
#     Call goodNodesRecursive() with the root, list of good nodes, and root.val as largest so far
# HELPER: def goodNodesRecursive(self, goodNodes, current, largestSoFar)
#     If not current:
#         Return count
#     If current.val > largestSoFar:
#         Update largestSoFar
#     Recursive call to left child
#     Recursive call to right child