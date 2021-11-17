// Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

// Although, the question may be same but this time I used iterate approach rather than recursion...

class Solution {
    public TreeNode convertBST(TreeNode root) {
        int max = 0;
        
        TreeNode currNode = root;
        Stack<TreeNode> s = new Stack();
        
        while(!s.isEmpty() || currNode != null){
            // save everything right
            if(currNode != null){
                s.push(currNode);
                currNode = currNode.right;
            }
            else{            
                currNode = s.pop();
                max += currNode.val;
                currNode.val = max;
                currNode = currNode.left;
            }
        }
        return root; 
    }
}
