class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] dp = new Integer[piles.size()+1][k+1];
        return maxValueOfCoins(piles,dp,0,k);
    }
    private int maxValueOfCoins(List<List<Integer>> piles, Integer[][] dp, int index, int k){
        if(k==0 ||index == piles.size())
            return 0;
        else if(dp[index][k]!=null)
            return dp[index][k];
        int res = maxValueOfCoins(piles,dp,index+1,k);
        int curr=0;
        for(int j=0;j<Math.min(piles.get(index).size(),k);j++){
            curr+=piles.get(index).get(j);
            res = Math.max(res, curr + maxValueOfCoins(piles,dp,index+1,k-j-1));
        }
        return dp[index][k] = res;
    }
}