class Solution {
    public int secondHighest(String s) {
        
        int firstMin = -1, secondMin = -1;
                
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                int curr = c - '0';
                
                if(curr > firstMin){
                    secondMin = firstMin;
                    firstMin = curr;
                }
                else if(secondMin < curr && curr < firstMin){
                    secondMin = curr;
                }
            }
            
        }
        
        
        return secondMin;
    }
}
