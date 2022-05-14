class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color == newColor)
            return image;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        int m = image.length;
        int n = image[0].length;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            image[x][y] = newColor;
            for(int[] d : dir){
                x = temp[0] + d[0];
                y = temp[1] + d[1];
                if(x>=0 && x<m && y>=0 && y<n && image[x][y] == color)
                    queue.offer(new int[]{x,y});
            }
        }
        return image;
    }
}