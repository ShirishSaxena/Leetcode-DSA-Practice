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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();
        
        getAllElements(root1, l1);
        getAllElements(root2, l2);
        
        // merge
        List<Integer> result = new ArrayList();
        
        int len_l1 = l1.size(), len_l2 = l2.size();
        
        int i = 0, j = 0;
        while(i < len_l1 && j < len_l2){
            if(l1.get(i) < l2.get(j))
                result.add(l1.get(i++));
            else
                result.add(l2.get(j++));
        }
        
        while(i < len_l1)
            result.add(l1.get(i++));
        while(j < len_l2)
            result.add(l2.get(j++));
        
        return result;       
    }
    
    private void getAllElements(TreeNode root, List<Integer> l){
        // inOrder traversal
        if(root == null) return ;
        
        getAllElements(root.left, l);
        l.add(root.val);
        getAllElements(root.right, l);
    }
}

/*
  We know both our input are Binary Search Tree so we can simply do inorder traversal for both, saving each node in a list.
  Then do MergeSort...
  
*/
