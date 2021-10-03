class Solution {    
    public String largestNumber(int[] nums) {
        
        // Store it as Strings array
        String[] nums_s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_s[i] = String.valueOf(nums[i]);
        }
        
        // Lamda function for custom comparator.
        Arrays.sort(nums_s, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        
        // if after sorting first number is zero
        // that means everything after it will be zero
        
        /*
        Assume input [0,0,0,0,0]
        After sorting it'll be same.
        We always have non-negative integers so first element in array can never 
        be equal to zero.
        
        */
        if (nums_s[0].equals("0")) return "0";

        // create new String and save into it.
        String result = "";
        
        for(String s : nums_s)
            result += s;
        
        return result;
    }
}

/*
This is something like you have to really remember for interviews?
Like if nums array only had limitations say Length <= 30 & 0 <= nums[i] >= 99
We could've sorted it simply, added a loop to get the lastmost one digit element.
Run two while loop.
First for single digit element where we start from last to first then second loop we do the same (keep adding it to resultatnt string).

But for this Comparator is the only option, I suppose?

Least, I learned something new about comparator.


*/
