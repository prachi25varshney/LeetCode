class Solution {
    public int maxProduct(String[] words) {
        int max =0;
        for(int i=0;i<words.length-1;i++){
            HashSet<Character> hs = new HashSet<>();
            for(char c : words[i].toCharArray())
                hs.add(c);
            for(int j=1;j<words.length;j++){
                if(notCommonChar(words[j],hs))
                    max = Math.max(max,words[i].length()*words[j].length());
            }
        }
        return max;
    }
    public boolean notCommonChar(String a, HashSet<Character> hs){
        for(char c : a.toCharArray()){
            if(hs.contains(c))
                return false;
        }
        return true;
    }
}