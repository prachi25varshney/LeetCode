class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek().chr == ch){
                if(st.peek().count == k-1  )
                    st.pop();
                else
                    st.peek().count++;
            }
            else
                st.push(new Pair(ch));
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop().toString());
        }
        return str.reverse().toString();
    }
    
    class Pair{
        char chr;
        int count;
        Pair(char ch){
            this.chr = ch;
            this.count = 1;
        }
        @Override
        public String toString(){
            return Character.toString(chr).repeat(count);
        }
    }
}