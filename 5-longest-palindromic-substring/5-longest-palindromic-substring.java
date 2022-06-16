class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        if(n==1)
            return s;
        String longString="", currString = "";
        int max=0,curr=0;
        for(int i=0;i<n;i++){
            currString = expandToCenter(s,i,i,n);
            curr= currString.length();
            if(curr>max){
                longString = currString;
                max = curr;
            }
            currString = expandToCenter(s,i,i+1,n);
            curr= currString.length();
            if(curr>max){
                longString = currString;
                max = curr;
            }
        }
        return longString;
    }
    public String expandToCenter(String str, int start, int end, int l){
        String res="";
        while(start>=0 && end<l && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return str.substring(start+1,end);
    }
}