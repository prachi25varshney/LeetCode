class Solution {
    
    int count =0;
    public boolean isSafe(int row, int col, int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(matrix[row][i]==1)
                return false;
        }
        for(int i=row,j=col; i>=0 && j>=0 ;i--,j--){
            if(matrix[i][j]==1)
                return false;
        }
        for(int i=row,j=col; i<matrix.length && j>=0;i++,j--){
            if(matrix[i][j]==1)
                return false;
        }
        return true;
    }
    public int totalNQueens(int n) {
        int sol[][] = new int[n][n];
        if(!totalNQueens(0,n,sol))
            return 0;
        return count;
    }
    public boolean totalNQueens(int col, int n, int[][] sol){
       if(col >= n){
           count++;
           return true;
       }
        boolean res = false;
        for(int i=0;i<n;i++){
            if(isSafe(i,col,sol)){
                sol[i][col] =1;
                res = totalNQueens(col+1,n,sol) || res;
                sol[i][col] = 0;
            }
        }
        return res;
    }
}