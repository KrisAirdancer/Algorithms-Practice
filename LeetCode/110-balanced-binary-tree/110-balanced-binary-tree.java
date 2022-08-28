/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /**
     * Recursively determines if each of the sub-trees under the given root are height-balanced binary trees.
     * Does so using a recursive helper method, maxDepth(), to determine the maximum depth of each of the 
     * left and right sub-trees of the given root node. isBalanced() itslef is also recursive, and calls
     * maxDepth() for each of the sub-trees in the given tree recursively and compares the depths of the
     * left and right trees as the recursion returns (comes back "up"). If ever this comparision yields
     * `false`, the entire function will resolve to false, indicating that at least one of the sub-trees
     * is not height-balanced.
     *
     * PERFORMANCE:
     * Time Complexity: O(N^2) - maxDepth() visits all of the children of a given root node and so is O(N). And since
     * isBalanced() calls maxDepth() on each of the child nodes in the given tree, the overall performance is O(N^2).
     * Memory Complexity: O(N) - For a tree of height H, we will have log(H) recursive calls for a balanced tree and
     * H recursive calls for a "binary stick" (linked list). Thus the worst case for recursive calls is O(H). Additionally,
     * the orignal tree that is passed into the isBalanced() function takes up O(N) space, where N is the number of nodes
     * in the tree. Thus, we get O(H) + O(N) and in worst case H = N, so our final memory complexity is O(2N) = O(N).
     *
     * SOURCE:
     * I worked through, implemented, and annotated the following solution to complete this problem:
     * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
     */
    public boolean isBalanced(TreeNode root) {
        // If the given binary tree is empty (has no nodes), it is balanced.
        if (root == null) {
            return true;
        }
        // Store the maximum depths of the current sub-trees
        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);
        
        /* If the difference in depth between the two sub-trees of this node is less than or equal to 1
         * AND
         * All of the sub-trees under the left child node of this root are balanced (as per a recusive call to this function: isBalanced())
         * AND
         * All of the sub-trees under the right child node of this root are balanced (as per a recursive call to this function: isBalanced())
         * THEN
         * Return true
         * ELSE
         * Return false
         */
        if (Math.abs(maxDepthLeft - maxDepthRight) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Determines the depth of the deepest child node under the given root node.
     * Recursively traverse to the bottom of each branch of the tree until the
     * deepest node is found. Then add one (+1) to the return value each time
     * the function returns to count the depth of that deepest node.
     */
    private int maxDepth(TreeNode root) {
        // If the bottom has been reached, return 0
        if (root == null) {
            return 0;
        }
        // Add one each time the function returnes to count (determine) the depth of the node that was found as the deepest.
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}