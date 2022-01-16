class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n;
        if(s.length()%k==0)
            n=s.length()/k;
        else
            n=s.length()/k +1;
        String[] result = new String[n];
        int j=0;
        for(int i=0;i<s.length();i=i+k){
            if(i+k<=s.length())
                result[j++] = s.substring(i,i+k);
            else{
                StringBuilder str = new StringBuilder();
                str.append(s.substring(i,s.length()));
                int length = str.length();
                for(int z =0;z<k-length;z++){
                    str.append(fill);
                }
                result[j++]  = str.toString();
            }
        }
        return result;
    }
}