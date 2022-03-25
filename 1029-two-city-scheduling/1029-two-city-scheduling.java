class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalSum=0;
        int[] diff = new int[costs.length];
        for(int i=0;i<costs.length;i++){
            totalSum = totalSum +costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(diff);
        for(int i=0;i<diff.length/2;i++){
            totalSum= totalSum + diff[i];
        }
        return totalSum;
    }
}