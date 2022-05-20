class Solution {
    
    int dir[][] = {{0, 1}, {1, 0}};
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;
        
        final int[][] dp = new int[rows][cols];
        
        for (int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        dp[rows-1][cols-1] = 1;
        
        return dfs(obstacleGrid, dp, 0, 0);
    }
    
    public int dfs(int[][] arr, int[][] cache, int r, int c) {

        if (cache[r][c] != -1) {
            return cache[r][c];
        }
        
        int count = 0;
        
        for (int i=0; i< dir.length; i++) {
            int newR = r + dir[i][0];
            int newC = c + dir[i][1];
            if (newR < arr.length && newC < arr[0].length && arr[newR][newC] == 0) {
                count += dfs(arr, cache, newR, newC);
            }
        }
        
        cache[r][c] = count;
        
        return count;
    }
}