//Question #965: Univalued Binary Tree
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return traverse(root, root.val);
    }


    public boolean traverse(TreeNode node, int val) {
        if(node == null) {
            return true;
        }
        if(node.val != val) {
            return false;
        }
        return traverse(node.left, val) && traverse(node.right, val);
    }
}
/* Simple DFS recursion. Traverse entire tree to leaf nodes, return either
 * true or false, bubble results up by && together the recursion results
 * of left and right subtrees.
 */

 class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if(cur.val != root.val) {
                return false;
            }
            if(cur.left !=  null) {
                queue.add(cur.left);
            }
            if(cur.right !=  null) {
                queue.add(cur.right);
            }
        }
        return true;
    }
}
/* Iterative solution using a queue to store child nodes. This is BFS
 */


// Question #612: Merge Two Binary Trees
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);

        return result;
    }
}
/* Intuitive recursion. If one node is null, return the other node. This
 * works even if both are null. Construct the new tree top down, merging the left
 * and the right recursively. 
 */
