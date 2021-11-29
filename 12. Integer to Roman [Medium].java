class Solution {
    final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final String[] Roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public String intToRoman(int num) {
        // check num for each iteration of values and 
        // subtract it from the num as well as append to result
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                result.append(Roman[i]);
            }
        }
        
        return result.toString();
    }
}

