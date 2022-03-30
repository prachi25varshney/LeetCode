class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=0,m=matrix.length,n=matrix[0].length;
        while(i<m && j<n){
            if(matrix[i][j]==target)
                return true;
            if(i+1<m && matrix[i+1][j]<=target)
                i++;
            else
                j++;
            
        }
        return false;
    }
}