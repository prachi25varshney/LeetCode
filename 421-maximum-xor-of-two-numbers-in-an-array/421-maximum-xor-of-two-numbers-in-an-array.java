class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask=0,ans=0,temp=0;
        HashSet<Integer>set=new HashSet();
        for(int i=31;i>-1;i--)
        {
            mask|=(1<<i);
            for(int a:nums)
                set.add(a&mask);
            temp=ans|(1<<i);
            for(int a:set)
                if(set.contains(a^temp))
                {ans=temp;
                 break; 
                }
            set.clear();
        }
     return ans;
    }
}