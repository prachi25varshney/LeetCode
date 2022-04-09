class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,n, isConnected, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int i, int n, int[][]isConnected, boolean[] visited){
        visited[i] = true;
        for(int j=0; j<n;j++){
            if(!visited[j] && isConnected[i][j] ==1){
                dfs(j,n, isConnected, visited);
            }
        }
    }
}