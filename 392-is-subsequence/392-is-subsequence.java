class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        if(t.length()==0)
            return false;
        int index=0;
        for(char ch : t.toCharArray()){
            if(index==s.length())
                return true;
            if(ch == s.charAt(index))
                index++;
        }
        return index==s.length();
    }
}