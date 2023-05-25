from pyparsing import Optional

class TreeNode: # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right    
def iterativeInOrderBinaryTreeTraversal(self, root: Optional[TreeNode], k: int) -> int:
        sortedNodes = [] # Array to store the output list in.
        nodesStack = [] # Stack to use to traverse the tree.
        current = root # Set the first node to the root node.

        while current or nodesStack: # Loop while there is at least one node to be processed. This is either 1) there are still nodes on the stack; OR 2) current is non-None, which means that we have a right node (current) and possibly its children to process.
            while current: # Traverse the entire left path.
                nodesStack.append(current) # Push the current node to the stack. We don't process them yet.
                current = current.left # Step further down the left path.
            
            current = nodesStack.pop() # Pop the current node off of the stack. The while loop above leaves current at the None child of the leftmost node on the left path. So we need to pop the parent of of the stack.

            sortedNodes.append(current.val) # Add the current node to the output list (the sorted list of nodes).

            current = current.right # Step to the right. We only do one right node per iteration of the outer loop b/c we need to step all the way to the left each time we visit a new node to ensure that we visit the smallest nodes first.

        return sortedNodes
