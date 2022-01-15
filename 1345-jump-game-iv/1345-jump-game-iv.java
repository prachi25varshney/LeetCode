class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> graph = new HashMap();
        int n = arr.length;
        for(int i=0;i<n;i++){
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        int jumps = 0;
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int index = queue.poll();
                if(index == n-1)
                    return jumps;
                List<Integer> paths = graph.get(arr[index]);
                paths.add(index-1);
                paths.add(index+1);
                for(int j : paths){
                    if(j>=0 && j<n && !visited.contains(j)){
                        queue.add(j);
                        visited.add(j);
                    }
                }
                paths.clear();
            }
            jumps++;
        }
        return -1;
    }
}