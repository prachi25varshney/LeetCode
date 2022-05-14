class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Pair<Integer,Integer>>[] graph = createGraph(times, n);
        
        int[] signals = new int[n+1];
        Arrays.fill(signals,Integer.MAX_VALUE);
        
        bfs(signals,k,graph);
        
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            ans = Math.max(ans, signals[i]);
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
        
    }
    private List<Pair<Integer,Integer>>[] createGraph(int[][]times, int n){
        List<Pair<Integer,Integer>>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList();
        }
        for(int[] time : times){
            graph[time[0]].add(new Pair(time[1],time[2]));
            
        }
        return graph;
    }
    private void bfs(int[] signal , int source, List<Pair<Integer,Integer>>[] graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        signal[source] =0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            int size = graph[curr].size();
            if(size ==0)
                continue;
            for(Pair<Integer,Integer> edge : graph[curr]){
                int nextNode = edge.getKey();
                int time = edge.getValue();
                
                int arrivalTime = signal[curr] + time;
                
                if(signal[nextNode] > arrivalTime){
                    signal[nextNode] = arrivalTime;
                    queue.add(nextNode);
                }
            }
        }
    }
}