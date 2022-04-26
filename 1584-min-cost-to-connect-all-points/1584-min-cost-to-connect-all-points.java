class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)->a.getKey()-b.getKey());
        
        boolean[] visited = new boolean[n];
        
        minHeap.add(new Pair(0,0));
        
        int minCost =0;
        int edge =0;
        
        while(edge<n){
            Pair<Integer,Integer> top = minHeap.poll();
            int weight = top.getKey();
            int currEdge = top.getValue();
            
            if(visited[currEdge])
                continue;
            visited[currEdge] = true;
            minCost = minCost + weight;
            edge++;
            
            for(int nextNode =0; nextNode<n ; nextNode++){
                if(!visited[nextNode]){
                    int dis = Math.abs(points[currEdge][0]-points[nextNode][0]) +
                        Math.abs(points[currEdge][1]-points[nextNode][1]);
                    minHeap.add(new Pair(dis,nextNode));
                }
            }
        }
        return minCost;
    }
}