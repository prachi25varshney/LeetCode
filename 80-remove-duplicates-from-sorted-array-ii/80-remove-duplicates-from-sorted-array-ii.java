class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[index] != nums[i] || (index-1<0 || nums[index-1] != nums[i])){
                nums[++index] = nums[i];
            } 
        }
        return index+1;
    }
}