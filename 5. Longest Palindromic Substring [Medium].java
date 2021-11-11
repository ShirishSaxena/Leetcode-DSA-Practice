class Solution {
    private int maxLen, currIdx;
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
                
        for(int i = 0; i < s.length() - 1; i++){
            getMaxPalindrome(s, i, i);
            getMaxPalindrome(s, i, i+1 );           
        }
        
        return s.substring(currIdx, currIdx + maxLen);
    }
    
    private void getMaxPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int currLen = right - left - 1;
        if(maxLen < currLen){
            maxLen = currLen;
            currIdx = left + 1;
        }
    }
}
