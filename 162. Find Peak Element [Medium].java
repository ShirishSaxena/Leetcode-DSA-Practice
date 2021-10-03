class Solution {
  
  // Time(Log(n))
  
  
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        
        if(nums.length == 1) return 0;
        
        while(left < right){
            int mid = left + (right-left)/2;
            
            if(nums[mid] > nums[mid+1])
                right = mid;
            else
                left = mid+1;
        }
        
        return left;
    }
}

/*
First brute force approach would be to go linear and have 2 variables (one for max, one for it's index). Keep iterating over, when we exit the loop.
Print the variable for index.

for binary search, it's kinda easy albeit needs some thinking :3


Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

left = 0, right = 6, mid = 3 || [1,2,1,3,5,6,4]
    Here, nums[mid] = 3 & nums[mid+1] = 5
      we move over to left (left = mid+1)
      
left = 4, right = 6, mid = 5
    nums[mid] = 6 & nums[mid+1] = 4
      we initiate right = mid;
      
left = 4, right = 5, mid = 4
    nums[mid] = 5 & nums[mid+1] = 6
      now left = mid+1;
      
left = 5, right = 5 {while condition returns false)
  exits the loop and return left;

*/
