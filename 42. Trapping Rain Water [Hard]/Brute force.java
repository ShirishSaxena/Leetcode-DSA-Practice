class Solution {
    // Max Runtime Leetcode [No Optimization] = 257ms
    // After Left call optimization = 129ms
    // After right call optimization = 2ms
    public int trap(int[] height) {
        // Brute force solution
        /* logic here is that we iterate through each elemtent while calling a helper function
           that finds max left and max right, we take whichever is minimum, subtract with currElement and add to
           global maxWater var, in any case the answer is negative, we neglect that.
        */
        
       
        
        // Testcases
        if(height.length <= 1) return 0;
        
        int maxWater = 0;
        
        // int maxLeft = 0;
        // int maxRight = findMax(height, 1, height.length);
        
        
        // we'll run this loop from 1 upto length-1
        // because boundaries can't hold anything so we just don't account for first and last element.
        for(int i=1; i < height.length-1; i++){
            /*
                Small optimization is we can use DP to store maxLeft as we're moving from left to right so instead of 
                int maxLeft = calling the function every iteration.
                we can simply do 
                
                maxLeft = (height[i-1] > height[maxLeft]) ? i-1 : maxLeft;
                
                this does halve the runtime but still have O(N*N) time complexity {O(N * (N/2));
            */
            
            /*
                By using the same logic as above we can further reduce findMax calls by simply specifying conditions that is;
                we first find maxHeight index before loop, and check if maxHeight index is greater than current i, if not call it again.
                
                
                maxRight = (maxRight <= i) ? findMax(height, i, height.length) : maxRight;
            */
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
