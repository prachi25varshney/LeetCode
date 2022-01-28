class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] != -1)
                continue;
            queue.offer(i);
            color[i] = 0;
            while (!queue.isEmpty()) {
                int key = queue.poll();
                for (int neighbour : graph[key]) {
                    if (color[neighbour] == color[key])
                        return false;
                    if (color[neighbour] == -1) {
                        color[neighbour] = 1 - color[key];
                        queue.add(neighbour);
                    }
                }
            }
        }
        return true;
    }
}