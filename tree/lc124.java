/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// divide and conquer, consider the maxPathDown, and compute the maxPath while compute the maxPathDown.
class Solution {
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxPathDown(root);
        
        return maxPath;
    }
    
    private int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, maxPathDown(root.left)); // consider the negative num.
        int right = Math.max(0, maxPathDown(root.right));
        
        maxPath = Math.max(maxPath, left + right + root.val);
        
        return root.val + Math.max(left, right);
    }
}