class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int maxOccuredNoInTops = maxOccuredNo(tops);
        int maxOccuredNoInBottoms = maxOccuredNo(bottoms);
        int[] topsInitial = new int[tops.length];
        int[] bottomInitial = new int[bottoms.length];
        for(int i =0 ;i< tops.length ; i++){
            topsInitial[i] = tops[i];
        }
        for(int i =0 ;i< bottoms.length ; i++){
            bottomInitial[i] = bottoms[i];
        }
        int minRotationInTops = minDominoRotationsUtil( topsInitial, bottomInitial, maxOccuredNoInTops );
        int minRotationInBottom = minDominoRotationsUtil( bottoms, tops, maxOccuredNoInBottoms);
        if(minRotationInTops == -1)
            return minRotationInBottom;
        return Math.min(minRotationInTops, minRotationInBottom);
    }
    private int maxOccuredNo(int[] arr){
        HashMap<Integer, Integer> hashMap = new HashMap();
        int maxCount=0, maxNo =0;
        for(int i : arr){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
            int currCount = hashMap.get(i);
            if(currCount>maxCount){
                maxCount = currCount;
                maxNo = i;
            }
        }
        return maxNo;
    }
    private int minDominoRotationsUtil(int[] A, int[] B, int no){
        int swaps = 0;
        for(int i=0;i<A.length; i++){
            if(A[i]!=no){
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
                swaps++;
            }
        }
        for(int i=0; i<A.length;i++){
            if(A[i]!=no)
                return -1;
        }
        return swaps;
    }
}