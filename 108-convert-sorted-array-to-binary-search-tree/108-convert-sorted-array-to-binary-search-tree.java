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
    * - Add the middle element of the array to as the root of the binary tree. Then, repeatedly find the middle of each of the sub-arrays (on either side of the previously
    * chosen element) and add them to the tree.
    * - That is, repeatedly divide the array in half and add the element at the middle (the point of the split) to the binary tree. Repeat until all elements have been added.
    * 
    * OUTLINE:
    * - Use a recursive solution to split the array in half, each time adding the middle element to the binary tree.
    * - Driver Method:
    *     - Find the middle of the input array -> `middle`
    *     - Make a new TreeNode as the `root` and store the value at `middle` in it.
    *     - Call recursive function, `sortedArrayToBSTRecursive()`
    *     - return the root
    * - Recursive Function:
    *     - Inputs:
    *         - nums - the original input array
    *         - middleNode - the current "root" node (the last node added to the tree)
    *         - leftIndex - the index of the leftmost element in the sub-array
    *         - rightIndex - the index of the rightmost element in the sub-array
    *     - Base case: If leftIndex > rightIndex, return
    *     - Find middle of given array using: low + ((high - low) / 2)
    *     - Make a new TreeNode that contains the element at the midpoint
    *     - if new node's value is less than that of middleNode, add to the left of middleNode
    *     - if new node's value is greater than that of middleNode, add to the right of middleNode
    *     - Call sortedArrayToBSTRecursive(middleNode, leftIndex, middle - 1) for the left sub-tree
    *     - Call sortedArrayToBSTRecursive(middleNode, middle + 1, rightIndex) for the right sub-tree
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int middleIndex = nums.length / 2;
        int middleValue = nums[middleIndex];
        TreeNode root = new TreeNode(middleValue);
        sortedArrayToBSTRecursive(nums, root, 0, middleIndex - 1); // Process left sub-array
        sortedArrayToBSTRecursive(nums, root, middleIndex + 1, nums.length - 1); // Process right sub-array
        
        return root;      
    }
    
    public void sortedArrayToBSTRecursive(int[] nums, TreeNode middleNode, int leftIndex, int rightIndex) {
        
        if (leftIndex > rightIndex) {
            return;
        }
        
        int middleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        
        TreeNode node = new TreeNode(nums[middleIndex]);
        
        if (node.val < middleNode.val) {
            middleNode.left = node;
        } else {
            middleNode.right = node;
        }
        
        sortedArrayToBSTRecursive(nums, node, leftIndex, middleIndex - 1); // Process left sub-array
        sortedArrayToBSTRecursive(nums, node, middleIndex + 1, rightIndex); // Process right sub-array
    }
}


















