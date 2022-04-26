class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[0] =0;
        
        boolean[] visited = new boolean[n];
        int minCost =0;
        int edge =0;
        
        while(edge<n){
            int minWeight = Integer.MAX_VALUE;
            int currEdge = -1;
           for(int i=0;i<n;i++) 
           { 
               if(!visited[i] && minWeight>costs[i]){
                    minWeight = costs[i];
                    currEdge = i;
            }    
           }
            visited[currEdge] = true;
            minCost = minCost + minWeight;
            edge++;
            
            for(int nextNode =0; nextNode<n ; nextNode++){
                if(!visited[nextNode]){
                    int dis = Math.abs(points[currEdge][0]-points[nextNode][0]) +
                        Math.abs(points[currEdge][1]-points[nextNode][1]);
                    if(costs[nextNode]> dis)
                        costs[nextNode] = dis;
                }
            }
        }
        return minCost;
    }
}