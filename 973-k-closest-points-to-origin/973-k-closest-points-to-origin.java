class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getKey()-b.getKey());
        
        for(int i=0; i< points.length;i++){
            int[] point = points[i];
            int dis = point[0]*point[0] + point[1]*point[1]; 
            pq.add(new Pair(dis,i));
        }
        
        int[][] res = new int[k][2];
        int i=0;
        System.out.println(pq);
        while(k-- > 0){
            Pair<Integer,Integer> temp = pq.poll();
            int[] arr = points[temp.getValue()];
            res[i++] = arr;
        }
        return res;
    }
}