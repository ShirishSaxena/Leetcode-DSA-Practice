class Solution {
    public int maxArea(int[] height) {
        // Optimised solution.
        // we'll use two pointer approach
        int left = 0, right = height.length-1;
        int maxArea = 0;
        
        while(right > left){
            int currArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, currArea);
            
            // conditions to increment or decrement left/right;
            if (height[left] <= height[right]) left++;
            else right--;
        }
        
        return maxArea;
    }
}


/*
Two pointer approach where we iterate over the elements once so Space will be O(N) and time O(1).

Linear runtime.

Here, the concept remains the same but we increment left or decrement right, depending upon the condition that is if element on the left is smaller than or equal to right,
we'll increment left. If not, simply decrement right.
*/
