class Solution {
    public List<String> generateParenthesis(int n) {
        // back tracking problem+
        List<String> result = new ArrayList<>();
        backTrack(result, "", 0, 0, n);
        return result;
    }
    
    
    // Helper function
    private void backTrack(List<String> result, String s, int openCount, int closeCount, int Max){
        if(s.length() == Max*2) // some condition where we add to list and return
        {
            result.add(s);
            return;
        }
        
        if(openCount < Max)
            backTrack(result, s + "(", openCount + 1, closeCount, Max);
        if(closeCount < openCount)
            backTrack(result, s + ")", openCount, closeCount + 1, Max);
        
        return;
    }
}


/*
Generic backtracking approach to generate all parentheses.

The template for generateParenthesis remains same for almost all backtracking problems with the caveat of different arguments for helper function.

{ I don't feel confident in backtrack as of now, would come back again in a month or two when I've practiced enough backtracking to see if there's something I can improve or well give better explaination.

*/
