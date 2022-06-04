class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean isSafe(int row, int col, String[][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(matrix[row][i].equals("Q"))
                return false;
        }
        for(int i=row,j=col; i>=0 && j>=0 ;i--,j--){
            if(matrix[i][j].equals("Q"))
                return false;
        }
        for(int i=row,j=col; i<matrix.length && j>=0;i++,j--){
            if(matrix[i][j].equals("Q"))
                return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        String sol[][] = new String[n][n];
        for(String[] s : sol)
            Arrays.fill(s,".");
        totalNQueens(0,n,sol);
        return ans;
      
    }
    
     public boolean totalNQueens(int col, int n, String[][] sol){
       if(col >= n){
           List<String> list = new ArrayList<>();
           for(int i=0;i<n;i++){
               String str="";
               for(int j=0;j<n;j++)
                   str = str + sol[i][j];
               list.add(str);
           }
               
           ans.add(list);
           return true;
       }
        boolean res = false;
        for(int i=0;i<n;i++){
            if(isSafe(i,col,sol)){
                sol[i][col] ="Q";
                res = totalNQueens(col+1,n,sol) || res;
                sol[i][col] = ".";
            }
        }
        return res;
    }
}