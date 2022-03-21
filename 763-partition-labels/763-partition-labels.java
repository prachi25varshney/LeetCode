class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionSize = new ArrayList<>();
        int[] lastIndex = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i; 
        }
        int maxLast =0, start =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            maxLast = Math.max(maxLast,lastIndex[ch - 'a']);
            if(i==maxLast){
                partitionSize.add(maxLast-start+1);
                start = i+1;
            }
        }
        return partitionSize;
    }
}