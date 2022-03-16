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
    
    // <summary>
    /// Recursive solution
    /// 
    /// In-Order Traversal:
    /// - N.Left
    /// - Use N
    /// - N.Right
    /// </summary>
    public IList<int> InorderTraversal(TreeNode root) {
        
        if (root == null) {
            return new List<int>();
        }
        
        IList<int> orderedNodes = new List<int>();
        return InorderTraversalRecursive(orderedNodes, root);
        
    }
    
    public IList<int> InorderTraversalRecursive(IList<int> orderedNodes, TreeNode start) {
            
        if (start.left != null) {
            InorderTraversalRecursive(orderedNodes, start.left);
        }

        orderedNodes.Add(start.val);

        if (start.right != null) {
            InorderTraversalRecursive(orderedNodes, start.right);
        }
        return orderedNodes;
    }
}