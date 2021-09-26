
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = BinarySearch(nums, target, true);
        result[1] = BinarySearch(nums, target, false);

        return result;
    }
    
    private int BinarySearch(int[] nums, int target, boolean isFirstPos){     
        int left = 0, right = nums.length-1;
        int first = -1;
        while(left<= right){
            int mid = left + (right-left)/2; 
            
            if(target == nums[mid]){
                first = mid;
                if(isFirstPos)
                    right = mid-1;
                else
                    left = mid+1;
            }
            else if(target > nums[mid]) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return first;
    }
}

// So here I ended up adding one boolean to the generic BinarySearch template.
// if boolean is true, that means we're finding firstPos otherwise second
// 
// when we find the target we check is same target exists the the left of the one we found {for first pos}
// same for second pos here we check right side.




/*

////////////////////////////////////////////////////////////////////////////
This works well enough but fails one of the test, which is 

Input: [3,3,3]
3
Output: [0,1]
Expected: [0,2]

I mean... anyhow there's another better implementation for this that passes
all tests.
////////////////////////////////////////////////////////////////////////////

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        // Arrays.fill(result, -1); 
        result[0] = result[1] = -1;
        
        int left = 0, right = nums.length-1;
        
        while(right >= left){
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target){
                result[0] = ((mid > 0) ?
                             
                             (nums[mid-1] == target) ? mid-1 : mid 
                             
                             : mid);
                
                result[1] = ((mid < nums.length-1) ?
                             
                             (nums[mid+1] == target) ? mid+1 : mid 
                             
                             : mid);
            }
            
            if(target > nums[mid]) left = mid+1;
            else right = mid-1;           
            
        }
        
        return result;
        
        
    }
  
  */

  
