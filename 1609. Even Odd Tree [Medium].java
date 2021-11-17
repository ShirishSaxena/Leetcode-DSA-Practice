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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        int levels = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int prevVal = (levels % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            while(size-- > 0){
                TreeNode currNode = q.poll();
                if(levels % 2 == 0)
                {                
                    if(currNode.val % 2 != 0){
                        if(currNode.val > prevVal) prevVal = currNode.val;
                        else
                            return false;
                    }
                    else return false;
                }
                else{
                    if(currNode.val % 2 == 0){
                        if(currNode.val < prevVal) prevVal = currNode.val;
                        else
                            return false;
                    }
                    else return false;
                }

                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
            }
            levels++;
        }
        
        return true;
    }
}

/*
  Quite simple logic tbh, as long as you know conditional statement and BFS...
  
  Runtime: 8 ms, faster than 95.87% of Java online submissions for Even Odd Tree.
  Memory Usage: 55.8 MB, less than 85.10% of Java online submissions for Even Odd Tree.
*/
