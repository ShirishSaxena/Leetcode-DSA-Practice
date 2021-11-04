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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        
        return DFS(root, root.val);
        
    }
    
    private boolean DFS(TreeNode root, int val){
        if(root == null) return true;
        if(root.val != val) return false;
        
        return DFS(root.left, val) && DFS(root.right, val);
    }
}

/*
  Not much to explain tbh, it's pretty easy...
*/
