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
     * 
     * PERFORMANCE:
     * - O(N) time complexity b/c the alg only visits each of the N nodes once.
     * - O(N) memory complexity in worst case b/c tree could be 100% unbalanced and be a binary stick. Therefore,
     * the recursion would require a maximum of N calls to be on the stack at the same time to reach the
     * bottom of the tree. If the tree is perfectly balanced, O(logN) memory complexity for the recursion,
     * but O(N) to store the tree, so still O(N) overall.
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