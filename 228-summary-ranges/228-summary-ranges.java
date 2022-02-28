class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < nums.length; i++)
        {
            str.setLength(0);
            int j = i;
            while(j < nums.length-1 && nums[j]+1 == nums[j+1])
            {
                j++;
            }
            if(j == i)
            {
                str.append("");
                str.append(nums[i]);
            }
            else
            {
                str.append(nums[i]);
                str.append("->");
                str.append(nums[j]);
            }
            res.add(str.toString());
            i = j;
        }
        return res;
    }
}