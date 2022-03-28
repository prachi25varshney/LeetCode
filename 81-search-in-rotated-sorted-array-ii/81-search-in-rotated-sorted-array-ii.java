class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length, low=0,high =n-1,pivot =0;
        while(low<=high){
            int m = low +(high-low)/2;
            if(nums[m]==target)
                return true;
            if(nums[m]>nums[low]) {
                if(target>=nums[low] && target<nums[m])
                    high = m-1;
                else
                    low = m +1;
            }
            else if (nums[m]<nums[low]){
                if(target <= nums[high] && target > nums[m])
                    low = m +1;
                else
                    high = m -1;
            }
            else
                low = low +1;           
        }
        return false;
    }
}