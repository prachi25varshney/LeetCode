class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0 || s.length() ==1)
            return 0;
        int count =0;
        Stack<Integer> st =  new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(')
                st.push(i);
            else{
                if(!st.isEmpty())
                    st.pop();
                
                if(!st.isEmpty())
                    count = Math.max(count, i- st.peek());
                
                else
                    st.push(i);
            }
        }
        return count;
    }
}