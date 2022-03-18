class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        sum -= target;
        if (sum < 0 || (sum & 1) == 1) {
            return 0;
        }
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num: nums) {
            for (int j = sum; j>= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
}