class Solution {
    public int minJumps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = new HashMap();//element, -> all indices the element has appeared 
        for (int i = 0; i < arr.length; i++) {
            graph.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> que = new LinkedList();
        que.offer(0);
        visited[0] = true;
        
        int steps = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int curIdx = que.poll();
                if (curIdx == arr.length - 1) {
                    return steps;
                }
                int leftIdx = curIdx - 1;
                if (leftIdx >= 0 && !visited[leftIdx]) {
                    que.offer(leftIdx);
                    visited[leftIdx] = true;
                }
                int rightIdx = curIdx + 1;
                if (rightIdx < arr.length && !visited[rightIdx]) {
                    que.offer(rightIdx);
                    visited[rightIdx] = true; 
                }
                if (graph.get(arr[curIdx]) != null) {
                    List<Integer> neighbors = graph.get(arr[curIdx]);
                    for (int nextIdx : neighbors) {
                        if (!visited[nextIdx] && curIdx != nextIdx) {
                            que.offer(nextIdx);
                            visited[nextIdx] = true;
                        }
                    }
                }
                graph.remove(arr[curIdx]);
            }
            steps++;
        }
        return -1;
    }
}