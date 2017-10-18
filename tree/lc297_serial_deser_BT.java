/**
 * 297. Serialize and Deserialize Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String spliter = ",";
    private static final String nuller = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        builder(root, sb);
        return sb.toString();
    }
    
    private void builder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nuller).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            builder(root.left, sb);
            builder(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        System.out.println(nodes.size());
        return builderTree(nodes);
    }
    
    private TreeNode builderTree(Deque<String> nodes) {
        String node = nodes.remove();
        TreeNode newNode;
        if (node.equals(nuller)) {
            return null;
        } else {
            newNode = new TreeNode(Integer.valueOf(node));
            newNode.left = builderTree(nodes);
            newNode.right = builderTree(nodes);
            return newNode;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));