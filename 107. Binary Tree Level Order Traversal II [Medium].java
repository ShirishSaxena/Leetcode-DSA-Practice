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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            
            int size = q.size();
            for(int i=0; i < size; i++){
                TreeNode tempNode = q.poll();
                tempList.add(tempNode.val);
                
                if(tempNode.left != null) q.offer(tempNode.left);
                if(tempNode.right != null) q.offer(tempNode.right);
            }
            result.add(tempList);
        }
        Collections.reverse(result);
        
        return result;
    }
}

/*
Simple BFS approach but at the end we reverse the result and return.

Follow up for me : do the same but without using reverse or reversing the resultant(can use stack?).
*/
