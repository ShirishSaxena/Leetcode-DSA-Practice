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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList();
        DFS(root, values);
        
        TreeNode newNode = new TreeNode(0);
        TreeNode currNode = newNode;
        for(int val : values){
            currNode.right = new TreeNode(val);
            currNode = currNode.right;
        }
        
        return newNode.right;
    }
    
    private void DFS(TreeNode root, List<Integer> values){
        
        if(root == null) return ;
        
        DFS(root.left, values);
        values.add(root.val);
        DFS(root.right, values);
        
    }
}

/*
  Can be optimised further and maybe it can be done in single DFS traversal?
  
  Anyway, simply inorder traversal here which adds values to a list then iterate over the list and keep adding elements to the right side.
  Time & Space
  O(N) & O(N)
*/
