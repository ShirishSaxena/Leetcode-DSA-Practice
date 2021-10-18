class Solution {
    // Sliding window
    /*
        We know that a string can't be a permutation of another if their length aren't equal
        to solve this issue we use Sliding window, we know we have to check if s2 contains a permutation of         s1.
        s1 & s2 consists of lowercase alphabets so we can use array of size 26 instead of hashMap.   
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] map = new int[26];
        
        // fill up map upto length of s1.
        for(int i=0; i < s1.length(); i++){
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        
        if(isAllZero(map)) return true;
        
        // sliding window starts here
        for(int i = s1.length(); i < s2.length(); i++){
            map[s2.charAt(i) - 'a']--; // decrement curr char in map
            map[s2.charAt(i - s1.length()) - 'a']++; // increment prev first char in map {to maintain size of s1.length}
            // call helper and check if all are zero
            if(isAllZero(map)) return true;
        }
        
        return false;
    }
    
    
    // helper function to check if map is zero or not, if so return true;
    private boolean isAllZero(int[] map){
        for(int i=0; i < 26; i++){
            if(map[i] != 0) return false;
        }
        return true;
    }
}
