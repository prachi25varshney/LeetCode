class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int index=0;
        for(int num : nums){
            if(!hashMap.containsKey(num) || hashMap.get(num)<2){
                hashMap.put(num, hashMap.getOrDefault(num,0)+1);
                nums[index++] = num;
            }
        }
        return index;
    }
}