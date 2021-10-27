class Solution {
    public String countAndSay(int n) {
        // base case
        String prev = "1";
        
        for(int i = 2; i <= n; i++){
            String curr = "";
            
            int idx = 0;
            while(idx < prev.length()){
                int count = 0;
                char currChar = prev.charAt(idx);
                
                while(idx < prev.length() && currChar == prev.charAt(idx)){
                    idx++;
                    count++;
                }
                curr = curr + count + currChar;          
            }
            prev = curr;
        }
        
        return prev;
    }
}

/*
This is just like solution of Q 443.
Was somewhat tricky to understand. Passed all tests.
However, it's not the effecient one...

Runtime: 24 ms, faster than 21.72% of Java online submissions for Count and Say.
Memory Usage: 39.7 MB, less than 25.30% of Java online submissions for Count and Say.

What can I say, other than to count my approach' and say xD???:
*/
