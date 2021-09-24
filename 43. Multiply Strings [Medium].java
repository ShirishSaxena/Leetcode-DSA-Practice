class Solution {
    public String multiply(String num1, String num2) {
        // save it in array and use stringbuilder to append, and finally return as string
        
        int m = num1.length();
        int n = num2.length();
        
        int[] sol = new int[m + n];
        int carry = 0;
        
        for(int i=m-1; i >= 0; i--){
            for(int j=n-1; j >= 0; j--){
                int multiplication = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                int pos1 = i+j, pos2 = i+j+1;
                int sum = multiplication + sol[pos2];
                
                sol[pos1] += sum/10;
                sol[pos2] = sum % 10;
            }
        }
        
        // simply iterate through sol and append to stringbuilder
        StringBuilder result = new StringBuilder();
        
        for(int f : sol){
            if(!(f == 0 && result.length() == 0))
                result.append(f);
        }
        
        return (result.length() == 0) ? "0" : result.toString();
    }
}

/*
Very simple, I don't think much explaination is needed.
We calculate multiplication from end of the strings, storing them on an array of size string1 + string2 (right to left)
Store the sum modulus {last digit of the multiplication} in string1 + string2 + 1 location and it's carry to string1+string2 location.

And then simply append to stringbuilder with a condtion.

return result if it isn't 0 otherwise '0'
*/
