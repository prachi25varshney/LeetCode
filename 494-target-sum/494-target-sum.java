class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        targetSum(nums, target, nums.length, 0);
        return count;
    }
    public void targetSum(int[] nums, int target, int n, int sum){
        if(n ==0){
            if(target==sum)
                count++;
        }
        else{
            targetSum(nums, target, n-1, sum+nums[n-1]);
            targetSum(nums, target, n-1, sum-nums[n-1]);
        }
    }
}