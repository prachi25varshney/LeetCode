class Solution {
    int[][] board;
    int m , n;
    public void gameOfLife(int[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveNeighbours = getTotalLiveNeighbour(i,j);
                if(board[i][j]==1)
                    result[i][j] = (liveNeighbours<2 || liveNeighbours >3) ?0:1;
                else
                    result[i][j] = liveNeighbours ==3 ? 1:0;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = result[i][j];
            }
        }
    }
    private int getTotalLiveNeighbour(int i,int j){
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int count =0;
        for(int k=0;k<8;k++){
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if(x>=0 && x<m && y>=0 && y<n && board[x][y] ==1)
                count++;
        }
        return count;
    }
}
