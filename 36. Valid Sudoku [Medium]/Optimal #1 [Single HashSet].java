class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet();
    
        for(int i = 0; i < 9; i++){
            for(int j=0; j < 9; j++){
                char currNo = board[i][j];
                if(board[i][j] != '.')
                    if(!set.add(currNo + "seen at row" + i) || 
                       !set.add(currNo + "seen at column" + j) || 
                       !set.add(currNo + "seen at subbox" + i/3 + "-" + j/3) )
                        return false;
            }
        }

        return true;
    }
}

/*
Unfortuanately, I wasn't able to come up with this.
I tried different method although it was quite inefficient, but worked, still I wasn't satisfied and headed over to discussion tab...

Eitherway, I'll come back to this question again in 2-3 months and hope to be able to solve it without looking or recalling what I've memorized.


*/
