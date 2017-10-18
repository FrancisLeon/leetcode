/**
 * 250. Count Univalue Subtrees.
 */
class Solution {
    int maxNum = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return maxNum;
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if (left == null && right == null) {
            maxNum++;
            return root;
        }
        
        if (left == null && right != null) {
            if (right.val == root.val) {
                maxNum++;
                return root;
            }
            return new TreeNode(Integer.MIN_VALUE);
        }
        
        if (right == null && left != null) {
            if (left.val == root.val) {
                maxNum++;
            }
            return new TreeNode(Integer.MIN_VALUE);
        }
        
        if (right != null && left != null) {
            if (left.val == root.val && right.val == root.val) {
                maxNum++;
                return root;
            }
            return new TreeNode(Integer.MIN_VALUE);
        }
        
        return new TreeNode(Integer.MIN_VALUE);
    }
}