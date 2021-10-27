/*
Just simply optimized the part where we store count.
Instead of Integer.toString().toCharArray();
we do 2 pass on count.
First, to simply store reverse using n%10
Then second to reverse ~reverse the range array...


Time : o(N)
Space : o(1)
*/

class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        
        int AnsIndex = 0;
        
        int idx = 0;
        while(idx < chars.length){
            char prev = chars[idx];
            int count = 0;
            
            while(idx < chars.length && prev == chars[idx]){
                count++;
                idx++;
            }
            chars[AnsIndex++] = prev;
            if(count != 1){
                int startIndex = AnsIndex;
                // simply store reverse count to curr char.
                while(count > 0){
                    chars[AnsIndex++] = (char) ((count % 10) + '0');
                    count /= 10;
                }
                
                int endIndex = AnsIndex - 1;
                // now reverse this part.
                while(startIndex < endIndex){
                    char temp = chars[startIndex];
                    chars[startIndex] = chars[endIndex];
                    chars[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
            }
        }
        return AnsIndex;
    }
}
