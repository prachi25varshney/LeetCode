class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;
        int j = 0;
        int count = 0;
        
        while(j < n) {
            j = i + 1;
            while(j < n && nums[j] - nums[i] < k) {
                j++;
            }
            if (j < n && nums[j] - nums[i] == k) {
                count++;
            }
            while(i + 1 < n && nums[i+1] == nums[i]) {
                i++;
            }
            i++;
        }
        return count;
    }
}