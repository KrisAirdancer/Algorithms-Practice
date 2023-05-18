# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        nodes = []

        if root: # If the root node isn't None, push it to the stack to initiate traversal.
            nodes.append(root)

        # Traverse the tree.
        while nodes: # Empty lists evaluate to False (they are Falsey). When the list is empty (there are no more child nodes), stop traversing the tree.
            currentNode = nodes.pop() # Get the next node in the tree.

            # Swap the two child nodes.
            temp = currentNode.left
            currentNode.left = currentNode.right
            currentNode.right = temp

            # Push non-None children onto the stack to continue traversal.
            if currentNode.right:
                nodes.append(currentNode.right)
            if currentNode.left:
                nodes.append(currentNode.left)
        
        return root
        
# ***** IDEAS *****
# > IDEA 1: 
#   > Use either a recursive or iterative approach to traverse the tree. For each node visited, swap the two children nodes (swap which nodes the "left" and "right" pointers point to).
#     > We can use a stack to traverse the tree iteratively. Push the children nodes to the stack. Then, on each iteration, pop the top node on the stack, process it, then push the two children to the stack.
#   > Base Case: Both children are None/Null, return.
# ***** OUTLINE *****
# > Use an iterative approach.
# > Instantiate a stack onto which nodes can be pushed.
# > Push the root node onto the stack.
# > Loop until the stack is empty.
#   > Pop the top element off of the stack - this is our currentNode.
#   > Swap the left and right pointers.
#     > temp = current.left
#     > current.left = current.right
#     > current.right = temp
#   > Push the left and right pointers of the node onto the stack.
#     > Only push a node if it is not None (if not None, push)
#     > Push right then left so that we maintain convention of processing the left route first.
# > Return the root node of the tree