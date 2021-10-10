class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i < 9; i++){
            HashSet<Character> row = new HashSet();
            HashSet<Character> col = new HashSet();
            HashSet<Character> Box = new HashSet();

            

            for(int j=0; j < 9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' &&!col.add(board[j][i]))
                    return false;
                int box_row = 3 * (i/3) + j/3;
                int box_col = 3 * (i%3) + j%3;
                if(board[box_row][box_col] != '.' && !Box.add(board[box_row][box_col]))
                    return false;
            }
        }
        
        return true;
    }    
}

/*
I guess String hashset takes more memory and runtime for some reason than 3 character set?
Eitherway, quite happy with this, I came up with row&col approach. Got stuck for box approach but from looking at the discussion and imagining how these
box_row/box_col would run... I feel good about it?


*/
