class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> list = new ArrayList<>();
        int[] count= new int[mat.length];
        int[] arr = new int[mat.length];
        for(int i =0;i<mat.length;i++){
            arr[i] = i;
            for(int j : mat[i]){
                if(j==1)
                    count[i]++;
            }
        }
        
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(count[arr[j]]>count[arr[j+1]]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                }
            }
        }
        int retArr[] =new int[k];
        for(int i=0;i<k;i++){
            retArr[i] = arr[i];
        }
        return retArr;
    }
}