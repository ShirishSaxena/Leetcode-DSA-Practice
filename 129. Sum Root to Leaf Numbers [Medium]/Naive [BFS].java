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
    // BFS solution
    public int sumNumbers(TreeNode root) {
        int total = 0, sum = 0;
        
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            
            if(curr.left == null && curr.right == null){
                total += curr.val;
            }
            
            if(curr.left != null){ 
                curr.left.val += (curr.val * 10);
                q.offer(curr.left);
            }
            if(curr.right != null) {
                curr.right.val += (curr.val * 10);
                q.offer(curr.right);
            }
        }
        return total;
    }
}

/*
  Changes val of tree and when we reach the leaf... we simply add its value to the global total variable.
  Won't work if follow up is to do it without changing node vals.
*/
