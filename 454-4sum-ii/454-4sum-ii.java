class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int fourSumCount =0;
        for(int i : nums1){
            for(int j : nums2){
                int sum =i+j;
                hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);
            }
        }
        for(int i : nums3){
            for(int j : nums4){
                int sum = -(i+j);
                if(hashMap.containsKey(sum))
                    fourSumCount+= hashMap.get(sum);
            }
        }
        return fourSumCount;
    }
}