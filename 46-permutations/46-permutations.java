class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> subList = new ArrayList<>();
        permuateUtil(subList, ans, nums);
        return ans;
    }
    
    private void permuateUtil(List<Integer> subList, List<List<Integer>> ans, int[] nums) {
        if (subList.size() == nums.length) {
            ans.add(new ArrayList<>(subList));
            return;
        } 
        for (int i=0; i<nums.length; i++) {
            if(subList.contains(nums[i])) {
                continue;
            }
            subList.add(nums[i]);
            permuateUtil(subList, ans, nums);
            subList.remove(subList.size()-1);
        }
    }
}