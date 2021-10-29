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
    List<String> result = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        DFS(root, new StringBuilder(), 0);
        
        return result;
    }
    
    private void DFS(TreeNode root, StringBuilder s, int size){
        if(root == null) return ;
        
        size = s.length();
        s.append(root.val);
        if(root.left == null && root.right == null)
            result.add(s.toString());
        else
            s.append("->");
    
        DFS(root.left, s, size);
        DFS(root.right, s, size);
        
        // backtrack
        s.setLength(size);
    }
}

/*
  generic approach using StringBuilder and InOrder DFS.
  Having done medium problems similar to this, makes it quite easy tbh. I wouldn't be able to come up with these approach if not for practicing similar problems.
  
  Anyhow, working here start by applying basic InOrder recursion template. We know a node is called leaf if node.left & node.right are both null;
  So we have the condition where we'll add result to final List which we return.
  
  Now comes the part where, we append and backTrack to remove previously visited node as well as "->". To do that simply check the length of StringBuilder then append
  and at the end setLength to size;

  Runtime: 1 ms, faster than 99.86% of Java online submissions for Binary Tree Paths.
  Memory Usage: 39.2 MB, less than 70.08% of Java online submissions for Binary Tree Paths.

*/
