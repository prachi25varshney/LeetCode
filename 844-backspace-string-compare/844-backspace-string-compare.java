class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder firstString = new StringBuilder(),  secondString = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(firstString.length()!=0 && ch=='#')
                firstString.deleteCharAt(firstString.length()-1);
            else if(ch!='#')
                firstString.append(ch);
        }
        for(char ch : t.toCharArray()){
            if(secondString.length()!=0 && ch=='#')
                secondString.deleteCharAt(secondString.length()-1);
            else if(ch!='#')
                secondString.append(ch);
        }
        s = firstString.toString();
        t = secondString.toString();
        return s.equals(t);
    }
}