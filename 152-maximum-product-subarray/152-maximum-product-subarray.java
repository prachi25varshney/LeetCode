class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int i=0;i<n;i++){
            int mul = nums[i];
            for(int j=i+1;j<n;j++){
                 max = Math.max(max,mul);
                 mul = mul * nums[j];
               
            }
             max = Math.max(max,mul);
        }
        return max;
    }
}