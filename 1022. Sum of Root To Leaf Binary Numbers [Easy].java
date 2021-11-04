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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        DFS(root, new StringBuilder());
        return sum;
    }
    
    private void DFS(TreeNode root, StringBuilder sb){
        if(root == null) return ;
        
        sb.append(root.val);
        if(root.left == null && root.right == null){
            int n = Binary2Int(sb.toString());
            sum += n;
        }
        
        DFS(root.left, sb);
        DFS(root.right, sb);
        
        sb.setLength(sb.length() - 1);
    }
    
    private int Binary2Int(String n){
        int num = 0;
        int len = n.length() - 1;
        for(int i = 0; i <= len ; i++){
            if(n.charAt(i) == '1')
                num += Math.pow(2,  len - i);
        }
        return num;
    }
    
    
    
}

/*
  I'm sure with some bit manipulation I can optimise it further but it works and is still pretty fast.
  The part that can be optimised is Binary2Int.
*/
