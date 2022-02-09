class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int kPairs =0;
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i],0)+1);
        }
        for(int i : hashMap.keySet()){
            if((k!=0 && hashMap.containsKey(i - k)) || (k ==0 && hashMap.get(i)>1))
                kPairs++;
        }
        return kPairs;
    }
}