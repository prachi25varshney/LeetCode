class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int count=0, x= intervals[0][0], y =intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            if(x < intervals[i][0] && y<= intervals[i][0]){
                x = intervals[i][0];
                y = intervals[i][1];
            }
            else{
                y = Math.min(intervals[i][1],y);
                count++;
            }
        }
        return count;
    }
}