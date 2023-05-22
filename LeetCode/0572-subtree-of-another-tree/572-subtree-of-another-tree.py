# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        nodes = [] # A stack for DFS.

        nodes.append(root)

        while nodes: # Loop over all nodes in root.
            currentNode = nodes.pop() # Get the current node.

            # If the current subtree matches the subRoot tree, we're done.
            if self.sameTree(currentNode, subRoot):
                return True

            # Add the current node's children to the stack to continue the traversal.
            if currentNode.right:
                nodes.append(currentNode.right)
            if currentNode.left:
                nodes.append(currentNode.left)
        
        return False


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
# ***** PSEUDO-CODE *****
# 