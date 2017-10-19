// divide and conquer.
/**
 * 95. Unique Binary Search Trees II
 */
class Solution {
    private static List<TreeNode> myList;
    public List<TreeNode> generateTrees(int n) {
        myList = new ArrayList<>();
        if (n <= 0) {
            return myList;
        }
        
        return generateTree(1, n);
    }
    
    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (start > end) {
            nodeList.add(null);
            return nodeList;
        }
        
        if (start == end) {
            nodeList.add(new TreeNode(start));
            return nodeList;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = generateTree(start, i - 1);
            right = generateTree(i + 1, end);
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    nodeList.add(root);
                }
            }
        }       
        /*
        for (int i = start; i <= end; i++) {
            left = generateTree(1, start - 1);
            right = generateTree(start + 1, end);
            TreeNode newNode = new TreeNode(i);
            left.forEach(e -> {
                newNode.left = e;
                right.forEach(a -> {
                    newNode.right = a;
                });
            });
        }*/
        return nodeList;
    }
}