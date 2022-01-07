class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        int max=0,i=0,j=0;
        HashMap<Character,Integer>hs = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(hs.containsKey(ch)){
                i = Math.max(i,hs.get(ch)+1);;
            }
            hs.put(ch,j);
            max = Math.max(max,j-i +1);
            j++;
        }
        return max;
    }
}