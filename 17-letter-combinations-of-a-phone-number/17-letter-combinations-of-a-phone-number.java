class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0 || digits==null)
            return list;
        int n = digits.length();
        String[] arr = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Queue<String> q = new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String str = q.poll();
            if(str.length()==n)
                list.add(str);
            else{
                String s = arr[Character.getNumericValue(digits.charAt(str.length()))];
                for(char c : s.toCharArray()){
                    q.add(str + c);
                }
            }
            
        }
        return list;
    }
}