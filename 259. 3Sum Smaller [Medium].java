class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3) return 0;
        int count = 0;
        Arrays.sort(nums);

        for(int i=0; i < nums.length - 2; i++){
            int j = i+1, k = nums.length - 1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    count += k - j;
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        
        return count;
    }
}
