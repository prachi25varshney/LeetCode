class Solution {
    public int maximumWealth(int[][] accounts) {
        int max_wealth = 0;
        for(int[] account : accounts){
            int currCustomerWealth = 0;
            for (int money : account) {
                currCustomerWealth += money;
            }
            max_wealth = Math.max(max_wealth, currCustomerWealth);
        }
        return max_wealth;
    }
}