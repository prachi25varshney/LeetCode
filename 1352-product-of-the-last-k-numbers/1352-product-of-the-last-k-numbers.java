class ProductOfNumbers {

    List<Integer> list;
    public ProductOfNumbers() {
        this.list = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0)
            list.clear();
        else {
            if(list.size()==0)
                list.add(num);
            else
                list.add(list.get(list.size()-1)*num);}
    }
    
    public int getProduct(int k) {
        int n = list.size();
        if(k==n)
            return list.get(n-1);
        if(k>n)
            return 0;
        else
            return list.get(n-1)/list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */