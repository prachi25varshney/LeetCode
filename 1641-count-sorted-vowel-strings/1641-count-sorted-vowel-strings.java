class Solution {
    HashMap<String,Long> hashMap = new HashMap<>();
    public int countVowelStrings(int n) {
        long a = count(n,'a');
        long e = count(n,'e');
        long i = count(n,'i');
        long o = count(n,'o');
        long u = count(n,'u');
        
        return (int)(a+e+i+o+u);
        
    }
    public long count(int n, char c){
        if(hashMap.containsKey(n+","+c))
            return hashMap.get(n+","+c);
        if(n==1)
            return 1;
        long res;
        if(c=='a')
            res= count(n-1,'a') + count(n-1,'e') + count(n-1,'i') + count(n-1,'o') + count(n-1,'u');
        else if(c=='e')
            res = count(n-1,'e') + count(n-1,'i') + count(n-1,'o') + count(n-1,'u');
        else if(c=='i')
            res = count(n-1,'i') + count(n-1,'o') + count(n-1,'u');
        else if(c=='o')
            res = count(n-1,'o') + count(n-1,'u');
        else
            res = count(n-1,'u');
        hashMap.put(n+","+c, res);
        return res;
        
        
    }
}