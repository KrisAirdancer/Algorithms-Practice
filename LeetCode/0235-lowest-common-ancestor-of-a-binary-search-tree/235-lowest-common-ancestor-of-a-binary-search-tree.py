# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':       
        if p.val < root.val and q.val < root.val: # Both nodes are to the left.
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val: # Both nodes are to the right.
            return self.lowestCommonAncestor(root.right, p, q)
        else: # LCA found. (A <= current && B >= current) || (A >= current && B <= current)
            return root
    
# ***** IDEAS *****
# > The two target nodes are passed in, so we don't have to find them in the given tree.
# 
# IDEA 1:
# > We could start at the two nodes p and q and traverse upward until our "pointers" meet.
#   > Of course, this won't work b/c our nodes are not doubly linked. That is, they are linked from parent to child and not from child to parent. This means that we cannot traverse the tree in reverse.
# 
# IDEA 2:
# > For each node in the tree, traverse down both subtrees (children) until both nodes are found.
# > Each time both target nodes are found, store the current node (the one where we began our search) in a variable: lowestCommonAncestor
# > Continue searching lower and lower nodes until at least one of the nodes is not found. At this point, return the current lowestCommonAncestor.
# > In terms of a recursive solution (I think iterative would be a bit of a mess), we could write a driver function that traverses the tree and calls a helper function on each of the nodes in the tree. The helper function will search the given subtree for both of the target nodes. If it finds both, it will return true; otherwise, it will return false. I'm just not 100% sure about how to keep track of the lowest ancester so far with this solution.
# 
# IDEA 3:
# > We can utilize the properties of the Binary Search Tree to determine where the target nodes are. That is, we can look at our current node and surmise whether both targets will be to the left/right or whether the targets will be split to either side of the current node.
# > Using the below conditions, we should be able to traverse the tree until we find the LCA of the two target nodes.
# > Conditions:
#   > If p < current && q < current, both target nodes are to the left of current
#     > Go left
#   > If P > current && q > current, both target nodes are to the right of current
#     > Go right
#   > If p < current && q > current, current is the Least Common Ancestor (b/c stepping down will loose us access to one of the target nodes)
#     > Return current
#   > If p > current && q < current, current is the Lease Common Ancestor
#     > Return current
# 
# ***** OUTLINE *****
# Base Case: If root is None, return - may not need this case b/c we shouldn't ever reach None nodes if our traversal is correct...
# Base Case: If (p >= current && q <= current) || (p <= current && q >= current), return root
# If p < current && q < current, recursive call to left child
# If p > current && q > current, recursive call to right child
# 
# ***** PERFORMANCE *****
# Time Complexity: O(logN) - We only have to visit one node on each level of the tree. This means that we will at most visit logN nodes in the tree (BSTs are balanced, so each time we step down a level, we cut half of the tree off).
# Memory Complexity: O(1) - We don't need any additional storage (no extra data structures).