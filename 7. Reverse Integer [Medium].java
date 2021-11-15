/*
  Using integer to save reverse and have conditions to prevent overflow
  
  Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
  Memory Usage: 35.9 MB, less than 85.26% of Java online submissions for Reverse Integer.
*/

class Solution {
    public int reverse(int x) {       
        int result = 0;
        while(x != 0){
            int currNo = x % 10;
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && currNo > (Integer.MAX_VALUE % 10)) return 0;
            if(result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && currNo > -(Integer.MIN_VALUE % 10)) return 0;
            
            result = (result * 10) + currNo;
            x /= 10;
        }
        
        return result;
    }
}


/*
  
*/
