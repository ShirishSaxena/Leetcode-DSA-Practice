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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currList = new ArrayList();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode currNode = q.poll();
                if(level % 2 != 0) currList.add(currNode.val);
                else currList.add(0, currNode.val);

                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
            }
            result.add(currList);
        }
        return result;
    }
}

/*
  Generic BFS approach but here we just keep track of levels and if level%2 == 0 this is where we do reverse insert, using list.add(0, val);
  
Runtime: 1 ms, faster than 84.28% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 39.5 MB, less than 31.56% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
*/




