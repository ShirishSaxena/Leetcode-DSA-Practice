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
    public String smallestFromLeaf(TreeNode root) {
        DFS(root, new String(""));
        Collections.sort(result);
        return result.get(0);
    }
    
    private void DFS(TreeNode root, String s){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            s = (char) ('a' + root.val) + s;
            result.add(s);
        }
        DFS(root.left, (char) ('a' + root.val) + s);
        DFS(root.right, (char) ('a' + root.val) + s);
    }
}

/*
Runtime: 12 ms, faster than 24.73% of Java online submissions for Smallest String Starting From Leaf.
Memory Usage: 40.3 MB, less than 45.90% of Java online submissions for Smallest String Starting From Leaf.
*/
