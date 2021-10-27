class Solution {
    public String countAndSay(int n) {
        // base case
        String prev = "1";
        
        for(int i = 2; i <= n; i++){
            StringBuilder curr = new StringBuilder();
            
            int idx = 0;
            while(idx < prev.length()){
                int count = 0;
                char currChar = prev.charAt(idx);
                
                while(idx < prev.length() && currChar == prev.charAt(idx)){
                    idx++;
                    count++;
                }
                curr.append(count);
                curr.append(currChar);       
            }
            prev = curr.toString();
        }
        
        return prev;
    }
}

/*
Now now now, ain't that something.
I knew I read in CTCI that for each insertion in char array/string, it's size gets (2n) and something it being slower than StringBuilder.

Voila, using stringbuilder I get :-

Runtime: 4 ms, faster than 72.18% of Java online submissions for Count and Say.
Memory Usage: 36.6 MB, less than 83.22% of Java online submissions for Count and Say.

*/
