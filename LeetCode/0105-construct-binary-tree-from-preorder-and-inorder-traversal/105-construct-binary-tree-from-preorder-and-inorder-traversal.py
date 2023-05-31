# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None

        root = TreeNode()
        root.val = preorder[0]

        mid = inorder.index(preorder[0]) # Find the root in the InOrder list. This to identify which elements are in the left subtree and which are in the right.
        
        inorderLeft = inorder[:mid] # Create the left partition.
        inorderRight = inorder[mid+1:] # Create the right partition.
        leftLen = len(inorderLeft)
        preorderLeft = preorder[1:leftLen+1] # Cut off the first element and stop at the last element in the left partition (note that splicing's right end is exclusive).
        preorderRight = preorder[leftLen+1:] # Cut off the first element plus the elements in the left partition to keep only the elements in the right partition.

        root.left = self.buildTree(preorderLeft, inorderLeft) # Build the left subtree.
        root.right = self.buildTree(preorderRight, inorderRight) # Build the right subtree.

        return root
        
# ***** IDEAS *****
# > The PreOrder list gives us a list of "roots" if you will. That is, each node in the tree is technically a root of a subtree within the entire tree.
# > The InOrder list tells us which nodes are to either side of a given node.
#   > That is, for a list [9 3 15 20 7], if 3 is our "root," then 9 is in the left subtree and nodes 15, 20, and 7 are in the right subtree rooted at 3.
#   > This is because InOrder traversals will "use" (record) the root of each subtree only after visiting every node in the left subtree. After this, the InOrder traversal will visit all of the nodes in the right subtree.
# > From this, we can use the PreOrder list to tell us the order of our root nodes. They are in a BFS ordering.
#   > That is, for [3 9 20 15 7], 3 is the tree's root, 9 is the root of the left subtree, 20 is the root of the right subtree, etc.
#   > However, we have to know whether the nodes 15 and 7 are in the left or right subtree. We can do this using the InOrder list. The InOrder list tells us that for root 3, 20 15 and 7 are in the right subtree. Since 20 appears first in the PreOrder list, it must be the case that 15 and 7 are in the subtree rooted at 20.
# > We can use a recursive solution to reconstruct the tree.
#   > We can recurse to the bottom of the "tree" (traverse to the position in the lists that reperesents this) and then build the actual tree as we unroll the recursion.
#   > Base case: 
# 
# ***** OUTLINE *****
# Base Case: If either list is empty
# Create a TreeNode: root
# root.left = buildTree() # Go left
# root.right = buildTree() # Go right
# Return root