class Solution {
    public int maxProfit(int[] prices) {
        int min_Price = Integer.MAX_VALUE;
        int max_Profit = 0;
        for(int i : prices){
            if(i<min_Price)
                min_Price = i;
            else if(i-min_Price>max_Profit)
                max_Profit = i-min_Price;
        }
        return max_Profit;
    }
}