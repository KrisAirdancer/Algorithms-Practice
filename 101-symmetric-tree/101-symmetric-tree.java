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
     * Use two queues to traverse the trees using a pre-order traversal of sorts.
     * push the children of the current node onto the queue (left child first, then right child for
     * one queue and right child first, then left child for the other queue - this to check for mirror).
     * Compare the current nodes, then pop the two nodes at the front of the queue, add their children
     * to the queue, then compare them, and repeat.
     * 
     * IMPLEMENTATION:
     * - Create two queues
     * - Add the child nodes of the root to the queues
     * - Loop (while queues are not empty):
     *     - Pop one node from each queue
     *     - Add the children nodes of the current nodes to the queues - only add non-null nodes
     *     - If current nodes are not equal, return false.
     * - If loop completes successfully, return true.
     * 
     * UPDATES/IMPROVEMENTS:
     * - I should only need one queue b/c I can push and pop in pairs - this will reduce the overall memory complexity.
     */
    public boolean isSymmetric(TreeNode root) {
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        
        nodes.add(root.left);
        nodes.add(root.right);
        
        while (!nodes.isEmpty()) {
            
            TreeNode leftNode = nodes.poll();
            TreeNode rightNode = nodes.poll();
            
            if (leftNode == null && rightNode == null) {
                continue;
            }
            
            if (leftNode == null || rightNode == null) {
                return false;
            }
            
            if (leftNode.val != rightNode.val) {
                return false;
            }
            
            nodes.add(leftNode.left);
            nodes.add(rightNode.right);
            nodes.add(leftNode.right);
            nodes.add(rightNode.left);
        }
        return true;
    }
}