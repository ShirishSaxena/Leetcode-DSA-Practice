class Solution {
    public int trap(int[] height) {
        // Optimised Solution
        // O(N) Time.
        
        // two pointer approach
        int left = 0, right = height.length-1;
        int maxLeft = 0, maxRight = 0;
        
        int maxWater = 0;
        // [4,2,0,3,2,5]
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] > maxLeft)
                    maxLeft = height[left];
                else
                    maxWater += (maxLeft - height[left]);
                left++;
            }
            else{
                if(height[right] > maxRight)
                    maxRight = height[right];
                else
                    maxWater += (maxRight - height[right]);
                right--;
            }
        }
        return maxWater;
    }
}

/*


*/
