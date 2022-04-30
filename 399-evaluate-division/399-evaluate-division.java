class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, 
                                 List<List<String>> queries) {
        Map<String,Map<String,Double>> equationValueMap =  new HashMap<>();
        
        for(int i=0;i<equations.size();i++){
            String firstElement = equations.get(i).get(0);
            String secondElement = equations.get(i).get(1);
            if(!equationValueMap.containsKey(firstElement))
                equationValueMap.put(firstElement, new HashMap());
            if(!equationValueMap.containsKey(secondElement))
                equationValueMap.put(secondElement, new HashMap());
            
            equationValueMap.get(firstElement).put(secondElement,values[i]);
            equationValueMap.get(secondElement).put(firstElement,1/values[i]);
        }
        
        double ans[] = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            if(!equationValueMap.containsKey(queries.get(i).get(0))|| !equationValueMap.containsKey(queries.get(i).get(1)))
                ans[i] = -1.00;
            else
                ans[i] = dfs(equationValueMap,queries.get(i).get(0),queries.get(i).get(1), new HashSet());
        }
        return ans;
    }
    
    
    private double dfs(Map<String,Map<String,Double>> map, String src, String des, HashSet<String> visited){
        if(!map.containsKey(des))
            return -1.00;
        if(map.get(src).containsKey(des))
            return map.get(src).get(des);
        visited.add(src);
        for(Map.Entry<String,Double> entry : map.get(src).entrySet()){
            if(!visited.contains(entry.getKey())){
                double ans = dfs(map, entry.getKey(), des, visited);
                if(ans!=-1.00)
                    return entry.getValue() * ans;
            }
        }
        return -1.00;
    }
}