class Solution {
    public int minDeletion(int[] nums) {
        int count = 0;
		for (int i = 1; i < nums.length; i += 2) {
			if (nums[i] == nums[i - 1]) {
				count++;
				i--;
			}
		}
		return count + (nums.length - count) % 2;
    }
}