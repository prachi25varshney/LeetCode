class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] ==1 || grid[n-1][n-1] == 1)
            return -1;
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        int pathLength=0;
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] temp = queue.poll();
                if(temp[0]==n-1 && temp[1]==n-1)
                    return pathLength+1;
                
                for(int i=0;i<8;i++){
                    int x = temp[0] + dir[i][0];
                    int y = temp[1] + dir[i][1];
                    if(x>=0 && y>=0 && x<n && y< n && grid[x][y]==0 && !visited[x][y] ){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            pathLength++;
        }
        return -1;
    }
}