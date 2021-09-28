class Solution {
    public int trap(int[] height) {
        // Brute force solution
        /* logic here is that we iterate through each elemtent while calling a helper function
           that finds max left and max right, we take whichever is minimum, subtract with currElement and add to
           global maxWater var, in any case the answer is negative, we neglect that.
        */
        
        // Testcases
        if(height.length <= 1) return 0;
        
        int maxWater = 0;
        
        // we'll run this loop from 1 upto length-1
        // because boundaries can't hold anything so we just don't account for first and last element.
        for(int i=1; i < height.length-1; i++){
            int maxLeft = findMax(height, 0, i);
            int maxRight = findMax(height, i, height.length);
            
            int canHold = Math.min(height[maxLeft], height[maxRight]) - height[i];
            if(canHold > 0) maxWater += canHold;
        }
        
        return maxWater;
    }
    
    // Helper function.
    private int findMax(int[] arr, int start, int end){
        int[] maxNo = new int[2];
        maxNo[0] = maxNo[1] = Integer.MIN_VALUE;
        for(; start < end; start++){
            if(arr[start] > maxNo[0]){
                maxNo[0] = arr[start];
                maxNo[1] = start;
            }
        }
        
        return maxNo[1];
    }
}
