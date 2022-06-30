class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int totalMoves =0;
        int no =  nums[nums.length/2];
        for(int i: nums){
            totalMoves = totalMoves + Math.abs(no -i);
        }
        return totalMoves;
    }
}