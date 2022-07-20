class Solution {
    
    public int numMatchingSubseq(String s, String[] words) {
        int num = 0;
        HashSet<String> isSub = new HashSet<>();
        HashSet<String> notSub = new HashSet<>();
        for(String word: words) {
            if( notSub.contains(word)) continue;
            if(isSub.contains(word)) {
                num++;
                continue;
            }
            if(isSubSequence(s, word)) {
                num++;
                isSub.add(word);
            } else notSub.add(word);
            
        }
        
        return num;
    }
    
    private boolean isSubSequence(String s, String word) {
        if(word.isEmpty()) return true;
        
        int j = 0;
        int found = 0;
        for(int i = 0; i < s.length(); i++) {
            if(found == word.length()) return true;
            
            if(s.charAt(i) == word.charAt(j)) {
                j++;
                found++;
            }
        }
        
        return found == word.length();
    }
}