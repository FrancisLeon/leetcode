// you have to know the relation between the preorder and inorder.
// since we don't know the number and structure of the tree, so we have
// to build the tree according to the two arrays.
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        // find the index of inorder, which is preStart of preorder.
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        
        TreeNode node = new TreeNode(inorder[index]);
        node.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        node.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        
        return node;
    }
}