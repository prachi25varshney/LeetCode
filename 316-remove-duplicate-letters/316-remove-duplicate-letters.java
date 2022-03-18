class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }
        Stack<Character> st = new Stack<>();
        HashSet<Character> visited = new HashSet();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(visited.contains(ch))
                continue;
            while(!st.isEmpty() && st.peek()>ch && i<lastIndex[st.peek()-'a']){
                char pop = st.pop();
                visited.remove(pop);
            }
            st.push(ch);
            visited.add(ch);
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.insert(0,st.pop());
        }
        return str.toString();
    }
}