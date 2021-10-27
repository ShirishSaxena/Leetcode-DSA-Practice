/*
Doesn't use constant space and it's quite uh... cluttered.
Uses Time : o(N) & Space : o(N) 

*/


class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        
        StringBuilder sb = new StringBuilder();
        
        char prev = chars[0];
        int count = 1;
        for(int i = 1; i < chars.length; i++){
            if(prev == chars[i])
                count++;
            else{
                if(count == 1){
                    sb.append(prev);
                    count = 1;
                    prev = chars[i];
                }
                else{
                    sb.append(prev);
                    sb.append(count);
                    count = 1;
                    prev = chars[i];
                }
            }
        }
        if(count == 1)
            sb.append(prev);
        else{
            sb.append(prev);
            sb.append(count);
        }

        
        for(int i=0; i < sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        
        return sb.length();
    }
}
