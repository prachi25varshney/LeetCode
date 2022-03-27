class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] nums = new int[mat.length];
        int[] result = new int[k];
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length;j++){
                if(mat[i][j] == 1) nums[i]++;
            }
        }
        
        int indexer = 0;
        
        while (k > 0) {
            int minIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            result[indexer++] = minIndex;
            nums[minIndex] = Integer.MAX_VALUE;
           
            k--;
        }

        return result;
    }
}