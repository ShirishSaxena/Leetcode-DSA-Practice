class Solution {
    public void setZeroes(int[][] matrix) {
        
        // Space O(m + n);
        boolean[] trackRow = new boolean[matrix.length];
        boolean[] trackColumn = new boolean[matrix[0].length];
        
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    trackRow[i] = true;
                    trackColumn[j] = true;
                }   
            }
        }
        
        for(int i=0; i < matrix.length; i++){
            // make rows zero that are true in trackRow & trackColumn.
            for(int j=0; j < matrix[0].length; j++)
                if(trackRow[i] || trackColumn[j])
                    matrix[i][j] = 0;

        }
    }
}

/*
Using O(m+n) space.
Simply create two boolean variable one for column o(m) and one for row o(n).
Now iterate over the matrix and check if any position in matrix is zero if true, set trackRow[i] = true and trackColumn[j] = true;

Finally, we again iterate over the matrix but this time we check if either trackRow[i] or trackcolumn[j] is true, if so simply set matrix[i][j] to zero
*/
