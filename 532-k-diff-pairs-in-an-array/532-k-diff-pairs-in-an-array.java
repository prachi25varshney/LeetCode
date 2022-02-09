class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Pair> hashSet = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j< nums.length;j++){
                if(Math.abs(nums[i] - nums[j]) == k)
                    hashSet.add(new Pair(nums[i], nums[j]));
            }
        }
        return hashSet.size();
    }
}