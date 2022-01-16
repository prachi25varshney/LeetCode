class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder str = new StringBuilder(s);
        while(str.length()%k!=0)
            str.append(fill);
        s = str.toString();
        int n = s.length()/k;
        String[] result = new String[n];
        int j=0;
        for(int i=0;i<s.length();i=i+k){
            result[j++] = s.substring(i,i+k);
           
        }
        return result;
    }
}