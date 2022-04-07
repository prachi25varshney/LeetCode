class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(y>x)
                maxHeap.offer(y-x);
        }
        if(maxHeap.size() ==0)
            return 0;
        return maxHeap.poll();
    }
}