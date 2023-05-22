# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balanced = True

        def isBalancedRecursive(current: Optional[TreeNode]) -> int:
            nonlocal balanced

            if not current:
                return -1

            leftHeight = isBalancedRecursive(current.left)
            rightHeight = isBalancedRecursive(current.right)

            if abs(leftHeight - rightHeight) > 1 or abs(leftHeight - rightHeight) < 0:
                balanced = False

            return max(leftHeight + 1, rightHeight + 1)

        isBalancedRecursive(root)

        return balanced

# ***** NOTES *****
# > Depth: The depth of a node is the number of edges between the root and the node.
#   > This is why the root has a depth of zero. It takes zero edges to get from the root to the root.
# > The definition of "height-balanced" binary tree in the problem description is incorrect. The correct definition of "height-balanced" binary tree, or just balanced binary tree, is: "a binary tree in which the height of the left and right subtree of any node never differs by more than one."
# 
# ***** IDEAS *****
# IDEA 1:
# > Recurse to the bottom of the tree. Then, as the recursion is unrolling, calculate the height of the subtrees. On each level, after the recursive call, compare the depths of the two subtrees of the current node. If they differ by more than 1, return false; otherwise, return true.
# > Will need to do this with a nested function and make a "global" boolean in the outer function to keep track of the return value.
# 
# ***** OUTLINE/PSEUDO-CODE *****
# Instantiate "balanced" = true (will be changed to false if an unbalanced subtree is found)
# Define nested recursive function as follows,
#     def helper(self, current) -> int: # depth: int
#         If not current:
#             return -1
#         left recursive call
#         right recursive call
#         If the leftSubtree.height != rightSubtree.height,
#             balanced = False
# Call nested recursive function
# Return "balanced"