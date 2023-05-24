# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def isValidHelper(current: Optional[TreeNode], min: int, max: int) -> bool:
            if not current:
                return True

            if current.val <= min or current.val >= max:
                return False

            return isValidHelper(current.left, min, current.val) and isValidHelper(current.right, current.val, max)

        return isValidHelper(root, float("-inf"), float("inf"))

# ***** IDEAS *****
# IDEA 1:
# > We might be able to do this in linear time by traversing the tree with a pre-order traversal.
# > For each node we visit, we check that the node's left child is smaller and its right child is larger.
# > The issue with this is that if a parent node and its children are valid relative to each other, this doesn't verify that they are valid relative to the nodes above or below it.
#   > Ex. If root is 10, root.left is 9, and root.left.right is 12; this alg won't catch that 12 is larger than the root, making it an invalid BST.
# > What if we ran the other direction?
# 
# NEETCODE:
# > The NeetCode solution is to do a DFS on the tree and check that each node is between some max and min values.
#   > Specifically, we define a range for each node that it must fall between, then check if it is in that range. If it is not, we return False.
#   > The root node can exist between negitaive infinity and positive infinity (it can be anything).
#   > If we step to a left child, we set MAX to the value of the parent node and leave MIN as is.
#   > If we step to a right child, we set MIN to the value of the parent node and leave MAX as is.\
# > We can do this using a recursive solution. We can use a helper function or nested function (still a helper) that takes in the current node, the min, and the max.
# 
# ***** OUTLINE *****
# Define nested function: isValidHelper(self, current, min, max)
#     if current.val > min && current.val < max:
#         return True
#     else:
#         return False
#     return isValidHelper(root.left, MININT, root.val) && isValidHelper(root.right, root.val, MAXINT)
# return isValidHelper(root.left, MININT, root.val) && isValidHelper(root.right, root.val, MAXINT)