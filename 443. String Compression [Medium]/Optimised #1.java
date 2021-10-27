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
                for(char c : Integer.toString(count).toCharArray())
                    chars[AnsIndex++] = c;
            }
        }
        return AnsIndex;
    }
}

/*
There it is, o(n) time with o(1) space.

Although, I am not so sure about "Integer.toString(count).toCharArray()". It should somehow require some kinda space, even if we aren't saving it?
After searching, I found that this above line is atleast log10(n).

Welp, guess I'll modify a bit again...

*/
