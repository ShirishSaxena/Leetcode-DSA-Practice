class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        if (nums == null || nums.length == 0) {
             return 0;
        }
        if (nums.length == 1) {
          return nums[0];
        }
        
        // what if nums is rotated 0 times?
        if(nums[right] > nums[0])
            return nums[0];
        
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            
            if(nums[mid] > nums[0])
                left = mid+1;
            else
                right = mid-1;
        }
        
        return -1;
    }
}
