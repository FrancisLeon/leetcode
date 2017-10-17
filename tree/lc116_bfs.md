lc116 is in fact another kind of bfs:
Let's compare it with the template of bfs:
- lc116:
    ```
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
    ```

- bfs template:
    ```
    public class Solution {
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
                ArrayList result = new ArrayList();
                if (root == null) {
                    return result;
                }
                Queue<TreeNode> queue = new LinkedList<TreeNode>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    ArrayList<Integer> level = new ArrayList<Integer>();
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode head = queue.poll();
                        level.add(head.val);
                        if (head.left != null) {
                            queue.offer(head.left);
                        }
                        if (head.right != null) {
                            queue.offer(head.right);
                        }
                    }
                result.add(level);
                }
            return result;
        }
    }
    ```

- similarity:
    in bfs, we search level by level, in template, we use the queue,
    we push the element of next level and pop the elements of the level.
    it's the same in the lc116, we have the level node and traversal the 
    next elements which is same as the pop in the bfs template.