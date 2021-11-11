class Solution {
    public int countSubstrings(String s) {
        if(s.length() <= 1) return s.length();
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++){
            maxLen += getMaxPalindrome(s, i , i);
            maxLen += getMaxPalindrome(s, i, i+1);
        }
        
        return maxLen;
    }

    private int getMaxPalindrome(String s, int left, int right){
        int currMax = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            currMax++;
            left--;
            right++;
        }
        return currMax;
    }
}

/*
Using Q.5 approach to extend palindrome and while in the loop, simply increment a local integer and return that integer.

*/
