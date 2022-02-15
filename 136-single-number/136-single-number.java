class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1) return nums[0];
        int res=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            res=res^nums[i];
        }
        return res;
    }
}