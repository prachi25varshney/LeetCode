class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0, high =0;
        for( int weight : weights){
            low = Math.max(low,weight);
            high+=weight;
        }
        if(days == 1)
            return high;
        int capacity =0;
        while(low < high){
            int mid = low + (high -low)/2;
            if(isPossible(weights,days, mid)){
                capacity = mid;
                high = mid;
            }else
                low = mid +1;
        }
        return capacity;
    }
    private boolean isPossible(int[] weights, int d, int minCapacity){
        int totalWeight =0;
        int days =1;
        for(int w : weights){
            totalWeight+=w;
            if(totalWeight>minCapacity){
                days++;
                totalWeight = w;
            }
        }
        return days<=d;
    }
}