class Solution {
    int n;
    List<Integer>[] list;
    boolean[] visited;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        this.n = s.length();
        this.list = new ArrayList[n];
        this.visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<pairs.size();i++){
            list[pairs.get(i).get(0)].add(pairs.get(i).get(1));
            list[pairs.get(i).get(1)].add(pairs.get(i).get(0));;
        }
        char[] ans = new char[n];
        
        for(int i=0;i<s.length();i++){
            if(!visited[i]){
                List<Character> charArray = new ArrayList<>();
                List<Integer> indexArray = new ArrayList<>();
                dfs(s,i,charArray,indexArray);
                Collections.sort(charArray);
                Collections.sort(indexArray);
                for(int index=0;index<charArray.size();index++){
                    ans[indexArray.get(index)] = charArray.get(index);
                }
            }
        }
        return new String(ans);
    }
    
    private void dfs(String s, int vertex,List<Character> charArray,List<Integer> indexArray){
        charArray.add(s.charAt(vertex));
        indexArray.add(vertex);
        visited[vertex] = true;
        
        for(int adjVertex :list[vertex]){
            if(!visited[adjVertex])
                dfs(s,adjVertex,charArray,indexArray);
        }
    }
}