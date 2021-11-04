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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 1; i < preorder.length; i++){
            Insert(root, preorder[i]);
        }
        
        return root;
    }
    
    private void Insert(TreeNode root, int val){
        while(root != null){
            if(val < root.val){
                if(root.left != null)
                    root = root.left;
                else{
                    root.left = new TreeNode(val);
                    return;
                }
                // left side
            }
            else{
                if(root.right != null)
                    root = root.right;
                else{
                    root.right = new TreeNode(val);
                    return;
                }
                // right side
            }            
        }
    }
}

/*
   Same implementation as the one you do when you start with Tree data structure (Insert function);
*/
