class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i=0, j=0;
        while(i<nums.length && j<nums.length){
            while(j+1<nums.length && nums[j]+1==nums[j+1]){
                j++;
            }
            if(i!=j){
                ans.add(nums[i]+"->"+nums[j]);
            }
            else{
                ans.add(""+nums[i]);
            }
            j++;
            i=j;
        }
        
        return ans;
    }
}