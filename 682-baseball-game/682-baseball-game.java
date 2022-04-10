class Solution {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for(String op : ops){
            int size = scores.size();
            if(op.equals("C"))
                scores.remove(size-1);
            else if(op.equals("D"))
                scores.add(2 * scores.get(size -1));
            else if(op.equals("+"))
                scores.add(scores.get(size -1) + scores.get(size -2));
            else
                scores.add(Integer.parseInt(op));
        }
        int totalScore =0;
        for(int score : scores)
            totalScore+= score;
        return totalScore;
    }
}