class Solution {
    List<List<Integer>> subsetList;
    List<Integer> set;
    public List<List<Integer>> subsets(int[] nums) {
        this.subsetList = new ArrayList<>();
        this.set = new ArrayList<>();
        getSubsets(nums,0);
        return subsetList;
    }
    public void getSubsets(int[] nums, int start){
        subsetList.add(new ArrayList<>(set));
        for(int i = start;i<nums.length;i++){
            set.add(nums[i]);
            getSubsets(nums,i+1);
            set.remove(set.size()-1);
        }
    }
}