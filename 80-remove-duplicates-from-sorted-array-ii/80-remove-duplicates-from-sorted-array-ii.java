class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(!hashMap.containsKey(num) || hashMap.get(num)<2){
                hashMap.put(num, hashMap.getOrDefault(num,0)+1);
                list.add(num);
            }
        }
        int i=0;
        for(int num : list){
            nums[i++] = num;
        }
        return list.size();
    }
}