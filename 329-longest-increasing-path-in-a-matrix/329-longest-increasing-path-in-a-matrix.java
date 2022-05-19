class Solution {
    int[][] matrix, dp;
    int row,column;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        row = matrix.length;
        column = matrix[0].length;
        int result =0;
        dp = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(dp[i][j]==0){
                    result = Math.max(result,dfs(i,j,Integer.MIN_VALUE));
                }
            }
        }
        return result;
    }
    public int dfs(int i, int j, int prev){
        if(i<0 || i>row-1 || j<0 || j>column-1 || matrix[i][j]<=prev)
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        int left = dfs(i,j-1,matrix[i][j]);
        int right = dfs(i,j+1,matrix[i][j]);
        int up = dfs(i-1,j,matrix[i][j]);
        int down = dfs(i+1,j,matrix[i][j]);
        
        dp[i][j] = Math.max(left,Math.max(right,Math.max(up,down))) +1;
        return dp[i][j];
    }
}