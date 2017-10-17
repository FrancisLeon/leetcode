// bfs
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode cur = level;
            while (cur !=  null) { // pop the node.
                if (cur.left != null) { // push left.
                    cur.left.next = cur.right;
                }
                
                if (cur.right != null && cur.next != null) { // push right.
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level = level.left;
        }        
    }
}