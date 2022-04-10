class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op : ops){
            if(op.equals("C"))
               stack.pop();
            else if(op.equals("D")){
                int top = stack.pop();
                int newTop = 2 *top;
                stack.push(top);
                stack.push(newTop);
            }
            else if(op.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }
            else
                stack.push(Integer.parseInt(op));
        }
        int totalScore =0;
        while(!stack.isEmpty())
            totalScore+= stack.pop();
        return totalScore;
    }
}