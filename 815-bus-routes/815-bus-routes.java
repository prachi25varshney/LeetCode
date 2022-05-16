class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target)
            return 0;
        HashMap<Integer, List<Integer>> routesMap = new HashMap();
        
        for(int j =0; j<routes.length;j++){
            int[] route = routes[j];
            for(int i =0; i<route.length;i++){
                if(!routesMap.containsKey(route[i]))
                    routesMap.put(route[i],new ArrayList());
                routesMap.get(route[i]).add(j);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count =0;
        queue.add(source);
        HashSet<Integer> visited = new HashSet();
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int temp = queue.poll();
                List<Integer> busList = routesMap.get(temp);
                for(int bus : busList){
                    if(!visited.contains(bus)){
                        visited.add(bus);
                        int[] route = routes[bus];
                        for(int r : route){
                            if(r == target){
                                return count+1;
                            }
                            else
                                queue.add(r);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}