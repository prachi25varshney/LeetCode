class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
        
        int[] count = new int[envelopes.length];
        int maxEnvelopes =0;
        for(int i=0;i<count.length;i++){
            
            int index = binarySearch(count, 0, maxEnvelopes, envelopes[i][1] );
            count[index] = envelopes[i][1];
            if(index == maxEnvelopes)
                maxEnvelopes++;
        }
        return maxEnvelopes;
    }
    private int binarySearch(int[] arr, int start, int end, int target){
        while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid]== target)
                return mid;
            if(arr[mid]> target)
                end = mid;
            else
                start =mid +1;
        }
        return start;
    }
}