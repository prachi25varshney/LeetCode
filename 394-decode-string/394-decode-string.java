class Solution {
    public String decodeString(String s) {
         int N = s.length();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int k = ch-'0';
                while (i+1 < N && Character.isDigit(s.charAt(i+1)))
                    k = k*10 + (s.charAt(++i)-'0');
                
                i++;
                int left = i;
                int balance = 0;
                while (true) {
                    if (s.charAt(i) == '[') balance++;
                    if (s.charAt(i) == ']') balance--;
                    if (balance == 0) break;
                    i++;
                }
                
                String decoded = decodeString(s.substring(left+1, i));

                while (k-- > 0) 
                    builder.append(decoded);
            }
            else
                builder.append(ch);
        }
        
        return builder.toString();
    }
}