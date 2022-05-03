class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return 0;
        int i=0;
        int j = n-1;
        while(i<n-1 && nums[i]<=nums[i+1])
            i++;
        if(i==n-1)
            return 0;
        while(j>i && nums[j] >= nums[j-1])
            j--;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int k =i;k<=j;k++){
            min = Math.min(min,nums[k]);
            max = Math.max(max,nums[k]);
        }
        while(i>0 && nums[i-1]>min)
            i--;
        while(j<n-1 && nums[j+1]<max)
            j++;
        
        return j-i +1;
    }
}