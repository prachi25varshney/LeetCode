class Solution {
    public int maximumWealth(int[][] accounts) {
        int max_wealth = 0;
        for(int[] account : accounts){
            int sum = Arrays.stream(account).reduce(0, Integer::sum);
            max_wealth = Math.max(max_wealth, sum);
        }
        return max_wealth;
    }
}