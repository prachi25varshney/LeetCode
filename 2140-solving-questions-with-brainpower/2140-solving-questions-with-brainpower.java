class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[ n +1];
        for(int i=0;i<=n;i++){
            if(i>0) dp[i] = Math.max(dp[i],dp[i-1]);
            if(i<n){
               int j = Math.min(n, i+questions[i][1]+1);
               dp[j] = Math.max(dp[j], dp[i] + questions[i][0]);
           }
        }
        return dp[n];
    }
}