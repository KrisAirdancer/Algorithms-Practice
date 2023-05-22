# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        pStack = []
        qStack = []

        pStack.append(p)
        qStack.append(q)

        # If the trees have a different number of nodes, a comparison will always be made while looping between a Null and Non-Null pairs of nodes. Thus, we shouldn't have to worry about incorrectly returning True here. That is, if one stack runs out of nodes, a None node from the empty stack will be compared to a non-None node from the other stack before the iteration in which the stack was emptied will occur and cause us to return False.
        while pStack and qStack:
            pNode = pStack.pop()
            qNode = qStack.pop()

            if (not pNode and qNode) or (pNode and not qNode):
                return False

            if (pNode and qNode) and (pNode.val != qNode.val):
                return False

            if pNode:
                pStack.append(pNode.right)
                pStack.append(pNode.left)
            if qNode:
                qStack.append(qNode.right)
                qStack.append(qNode.left)

        return True


# ***** IDEAS *****
# IDEA 1:
# > Iteratively traverse both trees using DFS. (although, it doesn't really matter what traversal method we use)
#   > Note that it must be iterative. If we use recursion, we will have to find a way to pass nodes between the different recursive calls that are created. At least I think we would have to.
#
# ***** OUTLINE *****
# Instantiate two stacks: pStack and qStack
# Push the root node of each tree to their resepecitve stacks.
# Loop over all of the nodes in the tree
#     Pop the current node off of each stack.
#     If pCurrent != qCurrent, return False
#     Push the left and right children of both trees to the stack.
# Return True