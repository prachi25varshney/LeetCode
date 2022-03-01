class Solution {
    StringBuilder str = new StringBuilder();
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++)
        {
            ans[i] = i%2 == 0 ? ans[i/2] : 1 + ans[(i-1)/2];
        }
        return ans;
    }
}