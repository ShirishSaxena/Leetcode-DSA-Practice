
// Optimised Time o(n) & space o(1)
class Solution {
    public boolean areNumbersAscending(String s) {
        // Time & Space
        // O(n) & o(1)
        int i = 0;
        int prev = 0;
        while(i < s.length()){
            int curr = 0;
            // loop to skip non digits
            while(i < s.length() && !Character.isDigit(s.charAt(i)))
                i++;

            // now get them digits
            while(i < s.length() && Character.isDigit(s.charAt(i)))
                curr = (curr * 10) + (s.charAt(i++) - '0');
            if(curr == 0) break;
            if(prev >= curr)
                return false;
            prev = curr;
        }

        return true;
    }
}

// No use of String.split(" ") is used here and no saving elements to an array...





// Naive Approach Space O(n) & Time o(n);
class Solution {
    public boolean areNumbersAscending(String s) {
        int i = 0;
        List<Integer> list = new ArrayList();
        while(i < s.length()){
            int sum = 0;
            // loop to skip non digits
            while(i < s.length() && !Character.isDigit(s.charAt(i)))
                i++;
                
            // now get them digits
            while(i < s.length() && Character.isDigit(s.charAt(i)))
                sum = (sum * 10) + (s.charAt(i++) - '0');
            if(sum != 0)
                list.add(sum);
        }
        
        
        for(int j = 1; j < list.size(); j++){
            if(list.get(j - 1) >= list.get(j))
                return false;
        }
        
        return true;
    }
}

/*
  while loop to generate list of integers in the string
  Then compare.
  we know `The number of tokens in s is between 2 and 100, inclusive.`
*/
