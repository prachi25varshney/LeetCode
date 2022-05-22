class Solution {
    public int countSubstrings(String s) {
        int count =0;
        for(int i=0;i<s.length();i++){
            count+=isPalindome(i,i,s);
            count+=isPalindome(i,i+1,s);
        }
        return count;
    }
    private int isPalindome(int start, int end, String s){
        int count =0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end ++;
            count++;
        }
        return count;
    }
}