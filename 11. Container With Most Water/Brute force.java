class Solution {
    public int maxArea(int[] height) {
        // brute force approach
        // we know area is L*W.
        // L/Length will be the minimum of left&right side while width will be distance between their index.
        int maxArea = 0;
        for(int i=0; i < height.length-1; i++){
            for(int j=i+1; j < height.length; j++){
                int currArea = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        
        return maxArea;
    }
}

// Time complexity O(n^2) because we have a nested loop which checks for every pair

/*
Example : [1,6,2,10]
Pairs from nested loop will be - (1,6) (1,2) (1,10) (6,2) (6,10) (2,10)
And we have index of everypair in second loop, we simply calculate currArea of these pairs and check it with maxArea(global).

This works but fails on very large input because O(N*N) :3

*/
