class Solution {
    public boolean isPalindrome(String s) {
        
        for(int i=0, j = s.length()-1; i < j;){
            if(!Character.isLetterOrDigit(s.charAt(i))) 
                i++;
            else if(!Character.isLetterOrDigit(s.charAt(j))) 
                j--;
            else if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) 
                return false;     
        }
        
        return true;
        
    }
}

/*
First approach I came up with was to strip everything off from string, create a new string and keep appending to it.
Now that we have clean string, simply do a loop with 2 pointers; one starts at 0 while other one from length of new string.
Increment first and decrement second, as long as both pos char are equal keep going otherwise return false;


This approach is far better and I honestly couldn't think of it on the stop, had to peek solutions.

Approach is same as about but instead of using o(n) space, we simply do the second loop this time, increment i/decrement j whenever we encounter non letter/char.
Guess it's self explanatory? 
*/
