class Solution {
    public String simplifyPath(String path) {
        //Stack<Character> operand = new Stack<>();
        Stack<String> st = new Stack<>();
        String str="";
        String[] arr = path.split("\\/");
        for(String p : arr){
            if(p.length()==0 || p.equals("."))
                continue;
            if(p.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(p);
        }
        while(!st.isEmpty()){
            str = "/"+ st.pop() + str;
        }
        if(str.length()==0)
            str="/";
        return str;
    }
}