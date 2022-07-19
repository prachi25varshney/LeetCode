class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows==1)
            return pascal;
        pascal.add(new ArrayList<>(Arrays.asList(1,1)));
        
        for(int i=2;i<numRows;i++){
            pascal.add(new ArrayList<>(Arrays.asList(1)));
            for(int j=1;j<i;j++){
                pascal.get(i).add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
            }
            pascal.get(i).add(1);
        }
        
        return pascal;
    }
}