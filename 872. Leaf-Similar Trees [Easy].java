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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();
        DFS(root1, l1);
        DFS(root2, l2);
        return l1.equals(l2);
    }
    
    private void DFS(TreeNode root, List<Integer> l){
        if(root == null) return ;
        
        // if is leaf
        if(root.left == null && root.right == null){
            l.add(root.val);
        }
        
        DFS(root.left, l);
        DFS(root.right, l);
    }
}

/*
Been a while since I last submitted any questions on github.
Have been practicing Tree based questions, although for almost all of them I end up peeking at the solution or discussion tab.
I sure don't copy and paste those solution, but I do throughly go through them, step by step, understanding each and every line of code.
And then after a quick break I came up with my own version.
*/
