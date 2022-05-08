public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> st = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;
        for(int i=nestedList.size()-1;i>=0;i--)
            st.push(nestedList.get(i));
        
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()){
            if(st.peek().isInteger())
                return true;
            else{
                NestedInteger top = st.pop();
                for(int i=top.getList().size()-1;i>=0;i--){
                    st.push(top.getList().get(i));
                }
            }
        }
        return false;
    }
}