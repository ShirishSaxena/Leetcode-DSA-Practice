class Solution {
    public int myAtoi(String s) {
        int idx = 0, sign = 1, result = 0;
        
        // In case Empty String...
        if(s.length() == 0) return 0;
        
        // skip white spaces
        while(idx < s.length() && s.charAt(idx) == ' ')
            idx++;
        
        // check curr char is +/-
        if(idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+'))
            sign = (s.charAt(idx++) == '-') ? -1 : 1;

        
        // Calculate
        while(idx < s.length()){
            int currNo = s.charAt(idx) - '0';
            if(currNo < 0 || currNo > 9) break;
            
            
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10  && currNo > Integer.MAX_VALUE%10)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            result = (result * 10) + currNo;
            idx++;
        }
        
        return (result * sign);        
    }
}
