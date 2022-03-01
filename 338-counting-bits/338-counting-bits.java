class Solution {
    StringBuilder str = new StringBuilder();
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1;i<=n;i++){
            str.setLength(0);
            binary(i);
            int ones = countOnes(str.toString());
            ans[i] = ones;
        }
        return ans;
    }
    public void binary(int n)
    {
        if (n > 1)
            binary(n / 2);
 
        str.append(n % 2);
    }
    public int countOnes(String bin){
        int count =0;
        for(char ch : bin.toCharArray()){
            if(ch=='1')
                count++;
        }
        return count;
    }
}