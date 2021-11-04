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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode Node = q.poll();
            TreeNode left = Node.left;
            Node.left = Node.right;
            Node.right = left;
                
            if(Node.left != null) q.offer(Node.left);
            if(Node.right != null) q.offer(Node.right);
        }
        return root;
    }
}

/*
  Simple BFS traversal where we do swap of left and right and then push left and right.
  Had to peek a little in discussion tab to fully understand the problem.
  
  I should probably start to use notepad and first do rough sketch on how I'll solve this problem then try to implement it rather than just simply going at the problem.
*/
