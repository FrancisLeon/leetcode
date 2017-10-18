/* dfs
class Solution {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return minDepth;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            depth = depth + 1;
            if (depth < minDepth) {
                minDepth = depth;
            }
            return;
        }
        
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}*/
// divide and conquer
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root);
    }
    
    private int getMinDepth(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
    }
}