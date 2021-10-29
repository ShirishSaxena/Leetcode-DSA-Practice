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
    String curr = "";
    public String smallestFromLeaf(TreeNode root) {
        DFS(root, new StringBuilder(""));
        return curr;
    }
    
    private void DFS(TreeNode root, StringBuilder s){
        if(root == null)
            return;
        
        s.insert(0, (char) ('a' + root.val));
        
        if(root.left == null && root.right == null){
            if(curr.length() > 0){
                String temp = s.toString();
                if(temp.compareTo(curr) < 0)
                    curr = temp;
            }
            else
                curr = s.toString();
        }
        DFS(root.left, s);
        DFS(root.right, s);
        
        s.deleteCharAt(0);
    }
}

/*
Woohoo!, finally I feel like I'm starting to get the gist of Tree and recursion problems.
Yet again, stringBuilder saves the day!

Runtime: 1 ms, faster than 99.69% of Java online submissions for Smallest String Starting From Leaf.
Memory Usage: 38.9 MB, less than 68.32% of Java online submissions for Smallest String Starting From Leaf.

*/
