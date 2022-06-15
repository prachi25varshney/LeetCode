class Solution {
    HashSet<String> hs = new HashSet<>();
    HashMap<String, Integer> map = new HashMap<>();
    public int longestStrChain(String[] words) {
        Collections.addAll(hs,words);
        int ans =0;
        for(String word : words){
            ans = Math.max(ans,dfs(word));
        }   
        return ans;
    }
    public int dfs(String word){
        if(map.containsKey(word))
            return map.get(word);
        int max =1;
        StringBuilder s = new StringBuilder(word);
        for(int i=0;i<word.length();i++){
            s.deleteCharAt(i);
            if(hs.contains(s.toString())){
                int length = 1 + dfs(s.toString());
                max = Math.max(max,length);
            }
            s.insert(i,word.charAt(i));
        }
        map.put(word,max);
        return max;
    }
}