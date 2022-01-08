class Solution {
    int[][][] cherries;
    int n, m;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        cherries = new int[n][m][m];
        for (int[][] row : cherries) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }
        return cherryPickupUtil(grid, 0, 0, m - 1);
    }

    private int cherryPickupUtil(int[][] grid, int row, int col1, int col2) { // col1 for robo1 and col2 for robo2
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m)
            return 0;
        if (cherries[row][col1][col2] != -1)
            return cherries[row][col1][col2];
        int totalCherries = 0;
        totalCherries += grid[row][col1];
        if (col1 != col2)
            totalCherries += grid[row][col2];
        if (row != n - 1) {
            int max = 0;
            for (int i = col1 - 1; i <= col1 + 1; i++) {
                for (int j = col2 - 1; j <= col2 + 1; j++) {
                    max = Math.max(max, cherryPickupUtil(grid, row + 1, i, j));
                }
            }
            totalCherries += max;
        }
        cherries[row][col1][col2] = totalCherries;
        return totalCherries;
    }
}