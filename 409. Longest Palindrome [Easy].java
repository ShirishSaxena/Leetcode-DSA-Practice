class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        
        for(char c : s.toCharArray())
            map[c]++;
        
        //
        boolean OneAlready = false;
        int count=0;
        for(int i = 0; i < 128; i++){            
            if(map[i] % 2 == 0)
                count = count + (map[i]);
            else if (map[i] % 2 != 0 && !OneAlready)
            {   
                count = count + (map[i]);
                OneAlready = true;
            }
            else
                count = count + (map[i] - 1);
        }
        
        return count;
    }
}

/*
  Came up with myself in under 5 mins :)
*/
