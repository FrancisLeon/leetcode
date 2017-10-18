// divide and conquer, and dfs.
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        
        List<String> pathsOfLeft = binaryTreePaths(root.left);
        List<String> pathsOfRight = binaryTreePaths(root.right);
        
        for (String path : pathsOfLeft) {
            paths.add(root.val + "->" + path);
        }
        
        for (String path : pathsOfRight) {
            paths.add(root.val + "->" + path);
        }
        
        if (paths.size() == 0) {// when you test the corner case, you will find it.
            paths.add("" + root.val);
        }
        
        return paths;
    }
}