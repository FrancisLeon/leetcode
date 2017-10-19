inorder traversal:
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<TreeNode> myStack = new Stack<>();
    List<Integer> myList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return myList;
        }
        init(root);
        while (hasNext()) {
            TreeNode node = next();
            myList.add(node.val);
        }
        return myList;
    }
    
    private void init(TreeNode root) {
        pushAll(root);
    }
    
    private boolean hasNext() {
        return !myStack.isEmpty();
    }
    
    private TreeNode next() {
        TreeNode nextNode = myStack.pop();
        pushAll(nextNode.right);
        return nextNode;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; node = node.left) {
            myStack.push(node);
        }
    }
}
```