/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        // simple BFS
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        TreeNode curr = null;
        
        while(!q.isEmpty()){
            curr = q.poll();
            if(curr.right != null) q.offer(curr.right);
            if(curr.left != null) q.offer(curr.left);
        }
        
        return curr.val;
    }
}

// Simple BFS but here we save queue poll to a tempNode and at the end we print curr.val which will be the left most one
