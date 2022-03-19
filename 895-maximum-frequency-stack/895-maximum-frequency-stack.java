class FreqStack {
    
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    ArrayList<Stack<Integer>> list = new ArrayList<>();
    public FreqStack() {
        list.add(new Stack<>());
    }
    
    int maxfreq =0;
    public void push(int x) {
        int freq = hashMap.getOrDefault(x,0)+1;
        hashMap.put(x,freq);
        maxfreq = Math.max(maxfreq, freq);
        if(maxfreq == list.size()) list.add(new Stack<>()) ; 
        list.get(freq).push(x);
    }
    
    public int pop() {
        
        int top = list.get(maxfreq).pop();
        hashMap.put(top, hashMap.get(top) -1);
        if(list.get(maxfreq).size()==0)
            maxfreq--;
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */