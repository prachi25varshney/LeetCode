class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        int arr[] = new int[nums.length+1];
        for(int no : nums){
            arr[no] =1;
        }
        while(i<nums.length){
            if(arr[i]!=1)
                return i;
            i++;
        }
      return i;  
    }
}