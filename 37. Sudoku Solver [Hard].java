/*
  Runtime: 9 ms, faster than 64.74% of Java online submissions for Sudoku Solver.
  Memory Usage: 36.2 MB, less than 87.29% of Java online submissions for Sudoku Solver.
*/

class Solution {
    char[][] input;
    public void solveSudoku(char[][] board) {
        this.input = board;
        Solve();
        board = this.input;
        // 2 helper function
    }
    
    private boolean Solve(){
        int row, col;
        row = col = -1;
        boolean isEmpty = true;
        
        for(int i=0; i < 9; i++){
            for(int j=0; j < 9; j++){
                if(this.input[i][j] == '.'){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }
        
        if(isEmpty) return true;
        
        for(int i=1; i <= 9; i++){
            if(helperSolve(row, col, i)){
                this.input[row][col] = (char) (i + '0');
                if(Solve())
                    return true;
                else
                    this.input[row][col] = '.';
            }
        }
        
        
        return false;
    }
    
    private boolean helperSolve(int row, int col, int num){
        // check row
        char n = (char) (num + '0');
        for(int i=0; i < 9; i++)
            if(this.input[row][i] == n) return false;
        
        // check col
        for(int i=0; i < 9; i++)
            if(this.input[i][col] == n) return false;
        
        
        // check subboxes
        int startCol = col - (col % 3);
        int startRow = row - (row % 3);
        int endCol = startCol + 3;
        int endRow = startRow + 3;
        
        for(int i = startRow; i < endRow; i++){
            for(int j = startCol ; j < endCol; j++){
                if(this.input[i][j] == n) return false;
            }
        }
            
        return true;
    }
}
