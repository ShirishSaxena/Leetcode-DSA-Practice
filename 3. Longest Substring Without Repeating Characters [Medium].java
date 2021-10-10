class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        
        HashSet <Character> set = new HashSet<>();
        
        int maxLength = 0;
                
        for(int i=0, j = 0; j < s.length();){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, set.size());
            }
            else
                set.remove(s.charAt(i++));
                
        }
        return maxLength;
    }
}

/*
Sliding window approach.

This is quite simple to follow once you know sliding window approach.
Take two pointers, move the second one (j) as long as char is not present in set. If it is, remove firstPointer char (i) from set and increment i.


At first, I keep getting wrong answer after 100/912 tests.
Found out that I was incrementing j even if set contains j.

    // for(int i=0, j = 0; j < s.length(); j++)
Whereas I should only increment window size whenever if condition satisfy.

*/
