class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.key-b.key);
        pq.add(new Pair(0,0));
        int n = points.length;
        int[] cost = new int[n];
        boolean[] visited = new boolean[n];
        int totalCost =0, edge=0;
        while(edge<n){
            Pair top = pq.poll();
            int currCost = top.getKey();
            int currPoint = top.getValue();
            if(visited[currPoint])
                continue;
            visited[currPoint] = true;
            totalCost += currCost;
            edge++;
            for(int nextPoint=0;nextPoint<n;nextPoint++){
                if(!visited[nextPoint]){
                    int dis = Math.abs(points[currPoint][0]-points[nextPoint][0]) +
                        Math.abs(points[currPoint][1]-points[nextPoint][1]);
                    pq.add(new Pair(dis, nextPoint));
                }
            }
            
        }
        return totalCost;
    }
    class Pair{
        int key; int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        int getKey(){
            return this.key;
        }
        int getValue(){
            return this.value;
        }
    }
}
