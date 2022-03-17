class Solution {
    public int scoreOfParentheses(String S) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(ch == '(')
                st.push(ch+"");
            else if(ch==')'){
                int temp = 0;
                while(!st.isEmpty() && !st.peek().equals("(")){
                    temp = temp + Integer.parseInt(st.pop());
                }
                st.pop();
                if(temp==0)
                    st.push("1");
                else
                    st.push(2*temp +"");
            }
        }
        int score =0;
        while(!st.isEmpty()){
            score = score +Integer.valueOf(st.pop());
        }
        return score;
    }
}