# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # THIS IS AN ITERATIVE DFS SOLUTION
        nodes = []
        maxDepth = 0

        if root:
            nodes.append((root, 1))

        while nodes:
            currentNode = nodes.pop()

            if currentNode[1] > maxDepth:
                maxDepth = currentNode[1]

            if currentNode[0].right:
                nodes.append((currentNode[0].right, currentNode[1] + 1))
            if currentNode[0].left:
                nodes.append((currentNode[0].left, currentNode[1] + 1))
            
        return maxDepth

# ITERATIVE DFS SOLUTION
# > This solution pushes each child node of the current node onto a stack. Because of this, on each iteration we will pull one child and push its children. This means that we will ignore the node's sibling until we've visited the entire subtree under the current node.
# ***** IDEAS *****
# IDEA 1:
# > Iteratively traverse the tree using a stack. For each node, push the node's children to the stack along with their "depth" (we are calculating depth backwards).
#   > That is, the root node will get pushed to the stack with a depth of 1, (node, 1). The root node will then get popped and its children will be pushed to the stack (if not None/Null) with the depth from thier parent (1) plus 1 = 2.
# > Each time we pop a node from the stack, we check to see if it's depth is greater than the maxDepth. If it is, we update maxDepth.
# > At the end, we return maxDepth.
# ***** OUTLINE *****
# > Instantiate a stack: nodes
# > Instantiate maxDepth = 0
# > Push the root node to the stack along with a depth of 1 as a tuple: (root, 1)
#   > Remember to check that the root is non-None/Null.
# > Loop while the nodes stack is non-empty,
#   > Pop the nodes stack: currentNode
#   > If currentNode[1] > maxDepth, update maxDepth.
#   > Push the non-None children of currentNode to the stack with depth values of currentNode.depth + 1
# > Return maxDepth