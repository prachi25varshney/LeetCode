class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int noOfBoxes =0, i=0, n= boxTypes.length;
        while(truckSize>0 && i<n){
            int count = Math.min(boxTypes[i][0],truckSize);
            noOfBoxes += count * boxTypes[i][1];
            truckSize -= count;
            i++;
        }
        return noOfBoxes;        
    }
}