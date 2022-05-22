class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums)
            hs.add(num);
        
        int length=0;
        for(int n : hs){
            if(!hs.contains(n-1)){
                int currN = n;
                int currLength =1;
                while(hs.contains(currN+1)){
                    currN+=1;
                    currLength+=1;
                }
                length = Math.max(currLength, length);
            }
        }
        return length;
    }
}