class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // o(n^2)
        int _3sum = nums[0] + nums[1] + nums[nums.length - 1]; // 2 ???...
        int ans = _3sum;
        
        // sort 
        Arrays.sort(nums);
        
        for(int i=0; i < nums.length - 2; i++){
            int j = i+1, k = nums.length-1;
            
            while(j < k){
                _3sum = nums[i] + nums[j] + nums[k];
                
                if(_3sum > target){
                    // skip dups as well
                    while(j < k && nums[k] == nums[k-1])
                        k--;
                    k--;
                }
                else if(_3sum < target){
                    while(j < k && nums[j] == nums[j+1])
                        j++;
                    j++;
                }
                else
                    return _3sum;
                
                if(Math.abs(target - _3sum) < Math.abs(target - ans))
                    ans = _3sum;
                
            }
        }
        
        return ans;
        
    }
}

/*
  I had forgotten what I did on 3sum, been a while I guess and need a refresher. Anyhow, same approach as 3Sum,
  but now with a condition to check for absolute difference and at the end return whichever is minimum.
*/
