class Solution {
    private static Stack<TreeNode> myStack;
    private static List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        
        int i = 0;
        init(root);
        while(hasNext()) {
            TreeNode nextNode = next();
            System.out.println("iteration: " + i);
            System.out.println(nextNode.val);
            res.add(nextNode.val);
        }
        System.out.println("over!!!");
        return res;
    }
    
    private static void init(TreeNode root) {
        myStack = new Stack<>();
        myStack.push(root);
    }
    
    private static boolean hasNext() {
        return !myStack.isEmpty();
    }
    
    private static TreeNode next() {
        TreeNode nextNode = myStack.pop();
        /* do something with root */
        if (nextNode.right != null) { // right
            myStack.push(nextNode.right);
        }
        if (nextNode.left != null) { // left
            myStack.push(nextNode.left);
        }
        
        // root, left, right
        return nextNode;
    }
}