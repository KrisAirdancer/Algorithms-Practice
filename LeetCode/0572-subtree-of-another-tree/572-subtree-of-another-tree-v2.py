# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root and not subRoot: # If both roots are None, subRoot is a subtree of root.
            return True
        if not root: # If root is None but subRoot isn't, subRoot cannot be a subtree of root.
            return False

        if self.sameTree(root, subRoot): # If the trees are the same, return True.
            return True

        # Return True if either recursive call finds a matching subtree.
        return (self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot))

    # This function determines if two trees are the same (same structure and same values).
    def sameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]):
        if not p and not q: # If both nodes are None, the trees are identical.
            return True
        if not p or not q: # If only one node is None (and one is not-None), the trees are not identical. Note that this check, combined with the check above, checks that exactly one node is None. It is not possible for both nodes to be None here. But it is possible for both nodes to be Non-None.
            return False
        if p.val != q.val: # If the nodes have different values, the trees are not the same.
            return False

        # Recursive calls on left and right subtrees. If either returns False, this expression will evaluate to False.
        return (self.sameTree(p.left, q.left) and self.sameTree(p.right, q.right))


# ***** IDEAS *****
# BFSol:
# > For each node in the tree, simultaneously traverse the subtree rooted at that node and the reference tree to see if they are the same.
# > Time Complexity: Not sure - ask Vista
#   > It is either somewhere around O(N^2) or O(NlogN) (for each node, visit logN other nodes)
#     > For each node, we don't visit all other nodes, so it's not exactly quadratic. But we do visit many of the nodes more than once, so it isn't linear. Thus, it seems likely that it will be somewhere around linearithmic.
# > Honestly, this is the best solution I can come up with.
# ***** OUTLINE *****
# Note: We might be able to use the provided function header as a recursive function to traverse the tree.
# OG FUNCTION: def isSubtree(...):
# Recursively call isSubtree() on each child of the current node.
#   > Ex. isSubtree(root.left) and isSubtree(root.right)
# Call sameTree() on the current root node.
#     If sameTree() returns True, we return True. Otherwise, we continue
#     Else, return False.
# 
# HELPER FUNCTION: def sameTree(root_1, root_2) -> bool:
# If both roots are none, return True
# If only one root is non-none, return False
# If values don't match, return False
# Recursively call sameTree() on both subtrees of the current node.
# ***** Time & Memory Complexity *****
# > The time complexity of this problem is not Linearithmic or Quadratic.
# > The time complexity is actually O(N * M), where N is the number of nodes in the root tree and M is the number of nodes in the subRoot tree.
#   > Essentially, for each node in the root tree, we visit a subtree at most the size of the subRoot tree.
#   > This means that we won't quite be O(N^2) b/c we can't be. If both trees are the same size (M == N -> N^2), we will continually be able to visit fewer and fewer nodes in the root tree b/c as we traverse down, we'll run out of nodes in the root tree to check against the subRoot tree.
#   > Thus, we will not visit every other node in root for each node in root we visit.
# Memory complexity is O(N + M) since we only need to store the input trees.