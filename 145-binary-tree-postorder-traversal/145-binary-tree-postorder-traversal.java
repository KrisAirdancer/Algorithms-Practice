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
     * IDEA:
     * - Use a recursive Postorder Traversal to visit every node and add them to an arraylist,
     * then return the arraylist.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> nodeList = new ArrayList<Integer>();
        
        postorderTraversalRecursive(root, nodeList);
        
        return nodeList;
    }
    
    private void postorderTraversalRecursive(TreeNode node, List<Integer> nodeList) { 
        
        if (node == null) {
            return;
        }
        
        postorderTraversalRecursive(node.left, nodeList); // Go left
        postorderTraversalRecursive(node.right, nodeList); // Go right
        
        nodeList.add(node.val);
    }
}