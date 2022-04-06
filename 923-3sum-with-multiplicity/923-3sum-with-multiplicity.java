class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Long> frequency = new HashMap<>();
        for(int i: arr){
            long freq = frequency.getOrDefault(i, 0l);
            frequency.put(i, freq+1l);
        }

        long ans =0;
        for(Integer x: frequency.keySet()){
            for(Integer y : frequency.keySet()){
                int z = target -x -y;
                if(frequency.containsKey(z)){
                    long xfreq = frequency.get(x);
                    long yfreq = frequency.get(y);
                    long zfreq = frequency.get(z);

                    if(x == y && x ==z){
                        ans += ((xfreq) * (xfreq-1)*(xfreq-2))/6;
                    } else if(x ==y && x!=z){
                        ans += ((xfreq)*(xfreq-1))/2 *zfreq;
                    } else if(x< y && y<z){
                        ans += ((xfreq*yfreq *zfreq));
                    }

                }
                ans = ans % 1000000007;
            }
        }
        return (int) ans;
    }
}