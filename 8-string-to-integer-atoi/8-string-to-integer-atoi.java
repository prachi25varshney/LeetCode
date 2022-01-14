class Solution {
    public int myAtoi(String s) {
        int res=0;
        int sign =1,i=0;
        if(s.length()==0)
            return 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(i<s.length() && s.charAt(i)=='-'){
            sign =-1;
            i++;
        }
        else if(i<s.length() && s.charAt(i)=='+')
            i++;
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(res>Integer.MAX_VALUE/10 || res==Integer.MAX_VALUE/10 && (c-'0')>7){
                    if(sign==-1)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                res = res*10 + c -'0';
            }
            else
                break;
        }
        return sign * res;
    }
}