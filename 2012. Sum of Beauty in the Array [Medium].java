class Solution {
    public int sumOfBeauties(int[] nums) {
        int result = 0;
        
        boolean[] suffixArr = new boolean[nums.length];
        int suffixF = nums[nums.length-1];
        suffixArr[nums.length-1] = true;
        
        for(int i=nums.length-2; i >= 0; i--){
            if(suffixF > nums[i]){
                suffixF = nums[i];
                suffixArr[i] = true;
            }
        }
        
        int leftMax = nums[0];
        for(int i=1; i < nums.length-1; i++){
            leftMax = Math.max(leftMax, nums[i-1]);
            
            if(leftMax < nums[i] && suffixArr[i])
                result += 2;
            else if(nums[i-1] < nums[i] && nums[i] < nums[i+1])
                result += 1;
        }
        return result;
    }
}

/*
  so here on first pass, we create a boolean array which tracks for condition first; that is, nums[i] < nums[k]. i < k <= nums.length-1;
  This array sets element to true if nums[i] is smaller than i+1.
  
  Then, before 2nd pass we init leftMax which keeps track to max of left side of array from 0 - i;
  Second pass simply iterate over the array from 1 - nums.length-2;
  
  


*/
