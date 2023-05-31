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
        
        root = TreeNode() # Instantiate a new node to use as the root of the tree.
        root.val = preorder[0] # Set the value of the new node to the first element in the preorder list. The first element in the preorder list will always be the root node.
        mid = inorder.index(preorder[0]) # Find the current node in the InOrder list to determine where the division between the left and right subtrees is.
        # Here, we make a recursive call and pass in ...
        # (1:mid + 1) makes a subarray containing all of the elements in preorder starting with the second element (excluding the first) and up to (and including) the middle element (the splice [] operator is exclusive on the right end, so the +1 ensures that mid is included).
        # (:mid) creates a subarray that includes all of the elements from (and including) the first element in the inorder array up to (but not including) the middle element.
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        # 
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])

        return root

# ***** IDEAS *****
# IDEA 1:
# > Note: This is NOT a Binary SEARCH Tree. Therefore, it will not have a particular ordering of the node values.
#   > If it was a BST, we could just iterate over the input list and build it easily.
# 
# NEETCODE:
# > The first note in the PreOrder list will always be the root.
#   > Also note that if we remove the first node in the PreOrder list, we will be left with an array whose first node is the root of the root's left subtree. This pattern continues all the way down.
#   > The only thing we have to watch out for here is that the input PreOrder list doesn't contain "NULL" whenever a node is missing.
#   > That is, we don't know where the splits between the left and right subtrees are.
# > The second thing to note is that the InOrder list can be used to determine which nodes belong in which subtree (left or right).
#   > For any given node in the InOrder list, all of the nodes to its left will be in its left subtree and all of the nodes to its right will be in the right subtree.
# > From the two points noted above, we can reconstruct the original Binary Tree.
#   > We can iterate over the PreOrder list to get the "roots" of each subtree (including the root of the entire tree - first node in the PreOrder list). Then, for each "root" that we encounter in the PreOrder list, we can use the InOrder list to determine which nodes are its left children and which nodes are its right children.
# 