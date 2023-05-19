# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # THIS IS A RECURSIVE DFS SOLUTION
        if not root:
            return 0
        
        return max( self.maxDepth(root.left) + 1, self.maxDepth(root.right) + 1 )

# RECURSIVE DFS SOLUTION
# ***** EXPLANATION *****
# > If we are using a DFS solution, we will traverse down an entire arm before returning. This means that we can count up the recursive calls as the recursion unrolls by adding 1 each time we return. Then, each time we return, we need to check which branch from that current point yielded the largest depth. Thus, each time we return, we only return the largest value that got returned to that recursive call.