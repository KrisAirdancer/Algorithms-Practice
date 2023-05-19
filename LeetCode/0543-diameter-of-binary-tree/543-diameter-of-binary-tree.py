# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        maxDiameter = 0

        # This is just declaring a nested function. It does not run unless we call it.
            # We could use a helper function instead, but that would be harder and more complicated. By using a nested function, we are able to simply update a global (global to the nested function, local to the parent function) variable in the parent function. If we used a helper method, we would have to find a way to pass both the height and maxDiameter back up through the function calls. We could return a tuple, but this would be a bit messy (although not too bad).
        def depthFirstSearch(root): # This function returns the height of the passed node (root).
            if not root:
                return -1 # Return -1 when the current node is Null/None. -1 because we are returning the height of the current node. If the node doesn't exist (because it is None), then it can't even have a height of zero because the height of leaf nodes is also zero. That is, if we return zero for None nodes, we will be indicating that None nodes are equivalent to leaf nodes, which is not the case. Thus, we need to do something to account for this issue. One way to fix the problem would be to do some sort of check, but that would be complicated and messy. Instead, we can simply set the value of None nodes to -1 to indicate that they are None. Then, as the recursion unrolls, the None nodes will effectively remove the +1 counter that is applied to them making them zero out, while the leaf nodes will not cancel out the +1 modifer that is added to them, giving them a value of 1. (Sort of, the value of a leaf node is still 0 and the value of None nodes is still -1)

            # Calculate the heights of the left and right children of the current node.
            leftHeight = depthFirstSearch(root.left)
            rightHeight = depthFirstSearch(root.right)

            # Calculate the diameter of the path that passes through the current node.
            diameter = leftHeight + rightHeight + 2 # +2 because the returned heights (leftHeight and rightHeight) don't account for the edges connecting the left subtree and right subtree to the current node. Thus, we need to add the "distance" covered by those edges.
            
            nonlocal maxDiameter # We have to make maxDiameter accessible inside the nested function, so we use the "nonlocal" keyword. If we simply try to use maxDiameter inside this nested function, Python will interpret it as a local variable and will fail to find the global version, causing an error. Thus, we need to tell Python to look somewhere else for the declaration of maxDiameter.
            if diameter > maxDiameter: # Update maxDiameter if we've found a larger diameter.
                maxDiameter = diameter

            # We only want to return the largest height of the two subtrees so that we can find the largest diameter.
            if leftHeight > rightHeight:
                return leftHeight + 1
            else:
                return rightHeight + 1
        
        depthFirstSearch(root) # Call the nested function to calculate the largest diameter.
        return maxDiameter