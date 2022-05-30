class Solution {
    public int maxArea(int[] height) {
//        int l=0;
//         int r=height.length-1;
//         int area =0;
//         while(l<r){
//             int lheight = height[l];
//             int rheight = height[r];
//             area = Math.max(area,((r-l)*Math.min(height[l],height[r])));
//             if(height[l]<height[r]){
//                 while(l<r && height[l] <= lheight)
//                     l++;
//             }
//             else{
//                 while(l<r && height[r] <= rheight)
//                     r--;
//             }
                
//         }
//         return area;
        int l = 0;
        int r = height.length - 1;
        int result = Integer.MIN_VALUE;
        int currentArea = Integer.MIN_VALUE;
        while ( l < r) {
            currentArea = Math.min( height[l], height[r] ) * (r -l);
            result = Math.max( currentArea, result );
            
            if ( height[l] < height[r] ){
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}