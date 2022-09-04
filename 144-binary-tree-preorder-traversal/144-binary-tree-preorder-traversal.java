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
     * IDEA: Write a recursive preorder traversal that adds each node to the return arraylist, then return the arraylist.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> nodeList = new ArrayList<Integer>();
        
        preorderTraversalRecursive(root, nodeList);
        
        return nodeList;
    }
    
    public void preorderTraversalRecursive(TreeNode node, List<Integer> nodeList) {
        // Base Case: Current node is null, return
        // Add node's integer to nodeList
        // Visit left node
        // Visit right node
        
        if (node == null) {
            return;
        }
        
        nodeList.add(node.val);
        
        preorderTraversalRecursive(node.left, nodeList);
        preorderTraversalRecursive(node.right, nodeList);
    }
}