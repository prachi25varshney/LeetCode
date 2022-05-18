class Solution {
    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<connections.size();i++){
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        Arrays.fill(disc,-1);
        for(int i=0;i<n;i++){
            if(disc[i]==-1)
                dfs(i,disc,low,graph,res,i);
        }
        return res;
    }
    public void dfs(int u, int[] disc, int[] low, List<Integer>[] graph, List<List<Integer>> list, int parent){
        disc[u] = low[u] = time++;
        for(int i=0;i<graph[u].size();i++){
            int v = graph[u].get(i);
            if(v==parent)
                continue;
            else if(disc[v]==-1){
                dfs(v,disc,low,graph,list,u);
                low[u] = Math.min(low[u],low[v]);
                if(low[v]>disc[u])
                    list.add(Arrays.asList(u,v));
            }
            else
                low[u] = Math.min(low[u],disc[v]);
        }
    }
}