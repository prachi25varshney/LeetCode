class Solution {

    public int minimumEffortPath(int[][] heights) {
       if (heights.length == 0 || heights[0].length == 0) return 0;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int[] distance = new int[m * n];
        boolean[] checked = new boolean[distance.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue.offer(new int[]{0, 0, 0});
        distance[0] = 0;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            int index = x * n + y;
            if (checked[index]) continue;
            checked[index] = true;
            for (int i = 0; i < dir.length; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                int nextIndex = nextX * n + nextY;
                int temp = Math.max(d, Math.abs(heights[x][y] - heights[nextX][nextY]));
                if (temp < distance[nextIndex]) {
                    distance[nextIndex] = temp;
                    queue.offer(new int[]{nextX, nextY, temp});
                }
            }
        }
        return distance[m * n - 1];
    }
}