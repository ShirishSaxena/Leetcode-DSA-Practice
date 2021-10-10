class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // brute force
        int max = Integer.MIN_VALUE;
        
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        
        Queue<Integer> currWin = new LinkedList();
        
        for(int i=0; i < nums.length; i++){
            currWin.offer(nums[i]);
            if(currWin.size() == k){
                result[count++] = getMax(currWin);
                currWin.poll();
            }
        }
        
        return result;
    }
    
    private int getMax(Queue<Integer> nums){
        int max = Integer.MIN_VALUE;
        for(int n : nums)
            max = Math.max(n, max);
        return max;
    }
}

/*
Time Limit exceeded : 42/69
*/
