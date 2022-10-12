/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    /** 
     * IDEA:
     * - Use recursion to traverse down the tree. Each recursive call will swap
     *   the two child nodes of the node that it is currently at with each other.
     *   If one of the child nodes is null, we still swap (this will account for
     *   trees with an uneven number of nodes), but if both child nodes are null
     *   we return (this is our Base Case).
     * 
     * EDGE CASES:
     * - An uneven number of nodes.
     *     - Not an issue b/c the parent of the leaf node that doesn't have a
     *       sibling will have a value of null where that sibling would have
     *       been. This means that when we swap the nodes, the null value
     *       will stand in for another node. No exceptions to deal with.
     * - A Binary Tree of length 0 (root is null)
     *     - Do a check for this in the driver method and return null
     *       if the tree is empty.
     * - A Binary Tree of lenght 1
     *     - No need to check for this. This will be caught by the base
     *       case of the recursive helper method and the given root will
     *       be returned by the driver method.
     * 
     * PERFORMANCE:
     * - Time Complexity:
     * - Memory Complexity: 
     * 
     * OUTLINE:
     * - Driver Method:
     *     - Call Recursive method with the current root node
     * - Helper Method:
     *     - Check Base Case: if both child nodes are null, return
     *     - Swap child nodes of current node
     *     - Call helper method on left child
     *     - Call helper method on right child
     */
    public TreeNode InvertTree(TreeNode root) {
        
        if (root == null) { return root; }
        
        InvertTreeRecursive(root);
        return root;
    }

    private static void InvertTreeRecursive(TreeNode currentNode) {
        
        if (currentNode.left == null && currentNode.right == null) {
            return;
        }
        
        TreeNode temp = currentNode.left;
        currentNode.left = currentNode.right;
        currentNode.right = temp;
        
        if (currentNode.left != null) {
            InvertTreeRecursive(currentNode.left);
        }
        if (currentNode.right != null) {
            InvertTreeRecursive(currentNode.right);
        }
    }
}