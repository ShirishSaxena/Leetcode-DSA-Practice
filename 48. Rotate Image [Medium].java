class Solution {
    public void rotate(int[][] matrix) {
        // in-place solve 2 steps
        // transpose then reverse
    
        int col = matrix.length;
        int row = matrix[0].length;

        for(int i=0; i < row; i++){
            for(int j=i; j < col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // step 2 reverse

        for(int i=0; i < row; i++){
            for(int j=0; j < col/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = temp;
            }
        }
    }
}

/*
InPlace 
Step 1 - Transpose
Step 2 - reverse
*/
